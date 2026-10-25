package service;

import static org.junit.Assert.*;
import dao.HallDAO;
import dao.MovieDAO;
import dao.ReservationDAO;
import dao.ScreeningDAO;
import dao.SeatDAO;
import dao.UserDAO;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import model.Hall;
import model.Movie;
import model.Reservation;
import model.Screening;
import model.Seat;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.TestDb;

/**
 * ReservationService testi: vietu rezervēšana, dubultas rezervācijas aizliegums, 15 minūšu atcelšanas noteikums
 * un datu integritāte (ārējās atslēgas, kaskādes dzēšana).
 */
public class ReservationServiceTest {

    private static final ZoneId ZONE = ZoneId.systemDefault();
    /** Seansa sākums: 2035-06-01 12:00. */
    private static final LocalDateTime START = LocalDateTime.of(2035, 6, 1, 12, 0);

    private final UserDAO userDAO = new UserDAO();
    private final MovieDAO movieDAO = new MovieDAO();
    private final HallDAO hallDAO = new HallDAO();
    private final SeatDAO seatDAO = new SeatDAO();
    private final ScreeningDAO screeningDAO = new ScreeningDAO();
    private final ReservationDAO reservationDAO = new ReservationDAO();

    private int user1;
    private int user2;
    private int movieId;
    private int hallId;
    private int otherHallId;
    private int screeningId;
    private List<Seat> seats;

    @BeforeClass
    public static void setUpClass() {
        TestDb.setUp();
    }

    @Before
    public void setUp() {
        cleanUp();
        user1 = userDAO.register(new User("A", "Viens", "rs_user1", "rs1@example.com", User.ROLE_CUSTOMER), "12345");
        user2 = userDAO.register(new User("B", "Divi", "rs_user2", "rs2@example.com", User.ROLE_CUSTOMER), "12345");
        movieId = movieDAO.addMovie(new Movie("RS testa filma", "Drāma", 100, "x"));
        hallId = hallDAO.addHall(new Hall("RS testa zāle 1", 6));
        seatDAO.addSeats(hallId, 2, 3);
        otherHallId = hallDAO.addHall(new Hall("RS testa zāle 2", 1));
        seatDAO.addSeats(otherHallId, 1, 1);
        screeningId = screeningDAO.addScreening(new Screening(movieId, hallId,
                START.toLocalDate(), START.toLocalTime(), new BigDecimal("7.50")));
        seats = seatDAO.findByHall(hallId);
        assertEquals(6, seats.size());
    }

    @After
    public void cleanUp() {
        userDAO.deleteUser("rs_user1");
        userDAO.deleteUser("rs_user2");
        for (Movie m : movieDAO.search("RS testa filma")) {
            movieDAO.deleteMovie(m.getId());
        }
        for (Hall h : hallDAO.findAllHalls()) {
            if (h.getName().startsWith("RS testa zāle")) {
                hallDAO.deleteHall(h.getId());
            }
        }
    }

    /** Pulkstenis, kas rāda laiku norādītās minūtes pirms seansa sākuma. */
    private ReservationService serviceMinutesBefore(long minutes) {
        return new ReservationService(Clock.fixed(START.minusMinutes(minutes).atZone(ZONE).toInstant(), ZONE));
    }

    @Test
    public void testReserveSeatSuccess() throws BusinessException {
        ReservationService service = serviceMinutesBefore(60);
        int id = service.reserveSeat(user1, screeningId, seats.get(0).getId());
        Reservation r = reservationDAO.findById(id);
        assertEquals(Reservation.STATUS_ACTIVE, r.getStatus());
        assertEquals(0, ReservationService.DEPOSIT.compareTo(r.getDeposit()));
        assertEquals(5, service.getFreeSeats(screeningId).size());
    }

    @Test
    public void testSameSeatCannotBeReservedTwice() throws BusinessException {
        ReservationService service = serviceMinutesBefore(60);
        service.reserveSeat(user1, screeningId, seats.get(0).getId());
        try {
            service.reserveSeat(user2, screeningId, seats.get(0).getId());
            fail("Divreiz rezervēta viena vieta!");
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("jau ir rezervēta"));
        }
    }

    @Test
    public void testSeatFromAnotherHallRejected() {
        int foreignSeat = seatDAO.findByHall(otherHallId).get(0).getId();
        try {
            serviceMinutesBefore(60).reserveSeat(user1, screeningId, foreignSeat);
            fail();
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("nepieder"));
        }
    }

    @Test
    public void testCannotReserveAfterScreeningStarted() {
        try {
            serviceMinutesBefore(-5).reserveSeat(user1, screeningId, seats.get(0).getId());
            fail();
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("sācies"));
        }
    }

    @Test
    public void testCancelFreesSeatForReuse() throws BusinessException {
        ReservationService service = serviceMinutesBefore(60);
        int id = service.reserveSeat(user1, screeningId, seats.get(0).getId());
        service.cancelReservation(user1, id);
        assertEquals(Reservation.STATUS_CANCELED, reservationDAO.findById(id).getStatus());
        assertEquals(6, service.getFreeSeats(screeningId).size());
        int again = service.reserveSeat(user2, screeningId, seats.get(0).getId());
        assertTrue(again > 0);
    }

    @Test
    public void testCancelAllowedExactly15MinutesBefore() throws BusinessException {
        int id = serviceMinutesBefore(60).reserveSeat(user1, screeningId, seats.get(0).getId());
        serviceMinutesBefore(15).cancelReservation(user1, id);
        assertFalse(reservationDao().findById(id).isActive());
    }

    @Test
    public void testCancelRejectedLessThan15MinutesBefore() throws BusinessException {
        int id = serviceMinutesBefore(60).reserveSeat(user1, screeningId, seats.get(0).getId());
        try {
            serviceMinutesBefore(14).cancelReservation(user1, id);
            fail("Atcelšana mazāk nekā 15 minūtes pirms seansa nedrīkst būt atļauta!");
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("15"));
        }
        assertTrue(reservationDao().findById(id).isActive());
    }

    @Test
    public void testCannotCancelSomeoneElsesReservation() throws BusinessException {
        int id = serviceMinutesBefore(60).reserveSeat(user1, screeningId, seats.get(0).getId());
        try {
            serviceMinutesBefore(60).cancelReservation(user2, id);
            fail();
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("nepieder"));
        }
    }

    @Test
    public void testCannotCancelTwice() throws BusinessException {
        ReservationService service = serviceMinutesBefore(60);
        int id = service.reserveSeat(user1, screeningId, seats.get(0).getId());
        service.cancelReservation(user1, id);
        try {
            service.cancelReservation(user1, id);
            fail();
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("jau ir atcelta"));
        }
    }

    @Test
    public void testAdminCanCancelEvenLate() throws BusinessException {
        int id = serviceMinutesBefore(60).reserveSeat(user1, screeningId, seats.get(0).getId());
        serviceMinutesBefore(1).cancelReservationAsAdmin(id);
        assertFalse(reservationDao().findById(id).isActive());
    }

    @Test
    public void testIsCancellationAllowedBoundary() {
        assertTrue(ReservationService.isCancellationAllowed(START, START.minusMinutes(16)));
        assertTrue(ReservationService.isCancellationAllowed(START, START.minusMinutes(15)));
        assertFalse(ReservationService.isCancellationAllowed(START, START.minusMinutes(14)));
    }

    /** Ārējā atslēga: nevar izveidot rezervāciju neeksistējošam lietotājam. */
    @Test
    public void testForeignKeyRejectsUnknownUser() {
        int id = reservationDAO.createReservation(new Reservation(999999, screeningId, seats.get(0).getId(),
                Reservation.STATUS_ACTIVE, ReservationService.DEPOSIT));
        assertEquals(-1, id);
    }

    /** Kaskādes dzēšana: dzēšot lietotāju, tiek dzēstas arī viņa rezervācijas. */
    @Test
    public void testDeletingUserDeletesReservations() throws BusinessException {
        int id = serviceMinutesBefore(60).reserveSeat(user1, screeningId, seats.get(0).getId());
        assertTrue(userDAO.delete(user1));
        assertNull(reservationDao().findById(id));
    }

    @Test
    public void testReservationViewJoinsData() throws BusinessException {
        serviceMinutesBefore(60).reserveSeat(user1, screeningId, seats.get(1).getId());
        List<model.ReservationView> views = reservationDAO.findViewsByUser(user1);
        assertEquals(1, views.size());
        model.ReservationView v = views.get(0);
        assertEquals("RS testa filma", v.getMovieTitle());
        assertEquals("RS testa zāle 1", v.getHallName());
        assertEquals(LocalDate.of(2035, 6, 1), v.getDate());
        assertEquals(LocalTime.NOON, v.getTime());
        assertEquals(seats.get(1).getSeatNumber(), v.getSeatNumber());
    }

    private ReservationDAO reservationDao() {
        return reservationDAO;
    }
}
