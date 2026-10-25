package service;

import dao.ReservationDAO;
import dao.ScreeningDAO;
import dao.SeatDAO;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import model.Reservation;
import model.Screening;
import model.Seat;

/**
 * Rezervāciju biznesa loģika: vietas rezervēšana (T5) un rezervācijas atcelšana (T7).
 *
 * <p>Noteikumi: rezervēt var tikai vēl nesākušos seansu; viena vieta seansā nevar tikt rezervēta divreiz;
 * rezervācijai nepieciešama 1 EUR iemaksa; klients rezervāciju var atcelt ne vēlāk kā 15 minūtes pirms seansa.</p>
 */
public class ReservationService {

    /** Iemaksa par vienu rezervāciju (EUR). */
    public static final BigDecimal DEPOSIT = new BigDecimal("1.00");

    /** Minūtes pirms seansa sākuma, līdz kurām klients vēl drīkst atcelt rezervāciju. */
    public static final int CANCEL_LIMIT_MINUTES = 15;

    private final ReservationDAO reservationDAO = new ReservationDAO();
    private final ScreeningDAO screeningDAO = new ScreeningDAO();
    private final SeatDAO seatDAO = new SeatDAO();
    private final Clock clock;

    /**
     * Izveido servisu, kas izmanto sistēmas pulksteni.
     */
    public ReservationService() {
        this(Clock.systemDefaultZone());
    }

    /**
     * Izveido servisu ar norādīto pulksteni (testiem).
     *
     * @param clock pulkstenis pašreizējā laika noteikšanai
     */
    public ReservationService(Clock clock) {
        this.clock = clock;
    }

    /**
     * Pārbauda, vai rezervāciju vēl drīkst atcelt.
     *
     * @param screeningStart seansa sākums
     * @param now pašreizējais laiks
     * @return true, ja līdz seansa sākumam atlikušas vismaz {@value #CANCEL_LIMIT_MINUTES} minūtes
     */
    public static boolean isCancellationAllowed(LocalDateTime screeningStart, LocalDateTime now) {
        return !now.plusMinutes(CANCEL_LIMIT_MINUTES).isAfter(screeningStart);
    }

    /**
     * Atgriež seansa brīvās vietas.
     *
     * @param screeningId seansa identifikators
     * @return brīvo vietu saraksts
     */
    public List<Seat> getFreeSeats(int screeningId) {
        return seatDAO.findFreeSeats(screeningId);
    }

    /**
     * Rezervē vietu seansā.
     *
     * @param userId klienta identifikators
     * @param screeningId seansa identifikators
     * @param seatId vietas identifikators
     * @return jaunās rezervācijas identifikators
     * @throws BusinessException ja seanss nav atrasts vai jau sācies, vieta nepieder zālei vai ir jau aizņemta
     */
    public int reserveSeat(int userId, int screeningId, int seatId) throws BusinessException {
        Screening screening = screeningDAO.findById(screeningId);
        if (screening == null) {
            throw new BusinessException("Seanss nav atrasts.");
        }
        if (!screening.getStartDateTime().isAfter(LocalDateTime.now(clock))) {
            throw new BusinessException("Seanss jau ir sācies vai beidzies.");
        }
        Seat seat = seatDAO.findById(seatId);
        if (seat == null || seat.getHallId() != screening.getHallId()) {
            throw new BusinessException("Izvēlētā vieta nepieder šī seansa zālei.");
        }
        if (reservationDAO.isSeatTaken(screeningId, seatId)) {
            throw new BusinessException("Šī vieta jau ir rezervēta.");
        }
        int id = reservationDAO.createReservation(
                new Reservation(userId, screeningId, seatId, Reservation.STATUS_ACTIVE, DEPOSIT));
        if (id == -1) {
            throw new BusinessException("Rezervāciju neizdevās izveidot. Mēģiniet vēlreiz.");
        }
        return id;
    }

    /**
     * Klienta veikta savas rezervācijas atcelšana (ne vēlāk kā 15 minūtes pirms seansa). Iemaksa netiek atgriezta.
     *
     * @param userId klienta identifikators
     * @param reservationId rezervācijas identifikators
     * @throws BusinessException ja rezervācija nav atrasta, nepieder klientam, jau ir atcelta vai atlicis pārāk maz laika
     */
    public void cancelReservation(int userId, int reservationId) throws BusinessException {
        Reservation reservation = reservationDAO.findById(reservationId);
        if (reservation == null) {
            throw new BusinessException("Rezervācija nav atrasta.");
        }
        if (reservation.getUserId() != userId) {
            throw new BusinessException("Šī rezervācija nepieder jums.");
        }
        if (!reservation.isActive()) {
            throw new BusinessException("Rezervācija jau ir atcelta.");
        }
        Screening screening = screeningDAO.findById(reservation.getScreeningId());
        if (screening == null || !isCancellationAllowed(screening.getStartDateTime(), LocalDateTime.now(clock))) {
            throw new BusinessException("Rezervāciju var atcelt ne vēlāk kā " + CANCEL_LIMIT_MINUTES
                    + " minūtes pirms seansa sākuma.");
        }
        markCanceled(reservationId);
    }

    /**
     * Administratora veikta jebkuras aktīvas rezervācijas atcelšana (bez laika ierobežojuma).
     *
     * @param reservationId rezervācijas identifikators
     * @throws BusinessException ja rezervācija nav atrasta vai jau ir atcelta
     */
    public void cancelReservationAsAdmin(int reservationId) throws BusinessException {
        Reservation reservation = reservationDAO.findById(reservationId);
        if (reservation == null) {
            throw new BusinessException("Rezervācija nav atrasta.");
        }
        if (!reservation.isActive()) {
            throw new BusinessException("Rezervācija jau ir atcelta.");
        }
        markCanceled(reservationId);
    }

    private void markCanceled(int reservationId) throws BusinessException {
        if (!reservationDAO.updateStatus(reservationId, Reservation.STATUS_CANCELED)) {
            throw new BusinessException("Neizdevās atcelt rezervāciju.");
        }
    }
}
