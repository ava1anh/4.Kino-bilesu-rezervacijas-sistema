package service;

import static org.junit.Assert.*;
import dao.HallDAO;
import dao.MovieDAO;
import dao.ScreeningDAO;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import model.Hall;
import model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.TestDb;

/**
 * ScreeningService testi: seansu plānošanas noteikumi.
 */
public class ScreeningServiceTest {

    private static final ZoneId ZONE = ZoneId.systemDefault();
    private static final LocalDate DAY = LocalDate.of(2036, 3, 10);
    private static final BigDecimal PRICE = new BigDecimal("6.00");

    private final MovieDAO movieDAO = new MovieDAO();
    private final HallDAO hallDAO = new HallDAO();
    private final ScreeningDAO screeningDAO = new ScreeningDAO();
    private final ScreeningService service =
            new ScreeningService(Clock.fixed(LocalDateTime.of(2036, 3, 1, 9, 0).atZone(ZONE).toInstant(), ZONE));

    private int movieId;
    private int hall1;
    private int hall2;

    @BeforeClass
    public static void setUpClass() {
        TestDb.setUp();
    }

    @Before
    public void setUp() {
        cleanUp();
        movieId = movieDAO.addMovie(new Movie("SS testa filma", "Drāma", 100, "x"));
        hall1 = hallDAO.addHall(new Hall("SS testa zāle 1", 10));
        hall2 = hallDAO.addHall(new Hall("SS testa zāle 2", 10));
    }

    @After
    public void cleanUp() {
        for (Movie m : movieDAO.search("SS testa filma")) {
            movieDAO.deleteMovie(m.getId());
        }
        for (Hall h : hallDAO.findAllHalls()) {
            if (h.getName().startsWith("SS testa zāle")) {
                hallDAO.deleteHall(h.getId());
            }
        }
    }

    @Test
    public void testAddScreeningSuccess() throws BusinessException {
        int id = service.addScreening(movieId, hall1, DAY, LocalTime.of(18, 0), PRICE);
        assertNotNull(screeningDAO.findById(id));
    }

    @Test
    public void testPastScreeningRejected() {
        try {
            service.addScreening(movieId, hall1, LocalDate.of(2036, 2, 1), LocalTime.of(18, 0), PRICE);
            fail();
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("nākotnē"));
        }
    }

    @Test
    public void testOverlappingScreeningInSameHallRejected() throws BusinessException {
        service.addScreening(movieId, hall1, DAY, LocalTime.of(18, 0), PRICE); // 18:00-19:55 (+pauze 20:10)
        try {
            service.addScreening(movieId, hall1, DAY, LocalTime.of(19, 30), PRICE);
            fail("Seansi pārklājas!");
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("jau notiek"));
        }
    }

    @Test
    public void testSameTimeInAnotherHallAllowed() throws BusinessException {
        service.addScreening(movieId, hall1, DAY, LocalTime.of(18, 0), PRICE);
        assertTrue(service.addScreening(movieId, hall2, DAY, LocalTime.of(18, 0), PRICE) > 0);
    }

    @Test
    public void testBackToBackAfterBreakAllowed() throws BusinessException {
        service.addScreening(movieId, hall1, DAY, LocalTime.of(18, 0), PRICE);
        assertTrue(service.addScreening(movieId, hall1, DAY, LocalTime.of(20, 10), PRICE) > 0);
    }

    @Test
    public void testInvalidPriceRejected() {
        try {
            service.addScreening(movieId, hall1, DAY, LocalTime.of(12, 0), BigDecimal.ZERO);
            fail();
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("Cenai"));
        }
    }
}
