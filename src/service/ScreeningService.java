/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DAO.HallDAO;
import DAO.MovieDAO;
import DAO.ScreeningDAO;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import Class.Movie;
import Class.Screening;
/**
 *
 * @author andre
 */
public class ScreeningService {

    /** Pauze (minūtes) pēc filmas beigām, līdz kurai zāle tiek uzskatīta par aizņemtu (uzkopšana). */
    public static final int BREAK_MINUTES = 15;

    private final MovieDAO movieDAO = new MovieDAO();
    private final HallDAO hallDAO = new HallDAO();
    private final ScreeningDAO screeningDAO = new ScreeningDAO();
    private final Clock clock;

    /**
     * Izveido servisu, kas izmanto sistēmas pulksteni.
     */
    public ScreeningService() {
        this(Clock.systemDefaultZone());
    }

    /**
     * Izveido servisu ar norādīto pulksteni (testiem).
     *
     * @param clock pulkstenis pašreizējā laika noteikšanai
     */
    public ScreeningService(Clock clock) {
        this.clock = clock;
    }

    /**
     * Pievieno jaunu seansu.
     *
     * @param movieId filmas identifikators
     * @param hallId zāles identifikators
     * @param date seansa datums
     * @param time seansa sākuma laiks
     * @param price biļetes cena (EUR)
     * @return jaunā seansa identifikators
     * @throws BusinessException ja filma vai zāle nav atrasta, seanss nav nākotnē, cena nav pozitīva
     *                           vai zālē šajā laikā jau notiek cits seanss
     */
    public int addScreening(int movieId, int hallId, LocalDate date, LocalTime time, BigDecimal price)
            throws BusinessException {
        Movie movie = movieDAO.findById(movieId);
        if (movie == null) {
            throw new BusinessException("Filma nav atrasta.");
        }
        if (hallDAO.findById(hallId) == null) {
            throw new BusinessException("Zāle nav atrasta.");
        }
        if (price == null || price.signum() <= 0) {
            throw new BusinessException("Cenai jābūt lielākai par nulli.");
        }
        LocalDateTime start = LocalDateTime.of(date, time);
        if (!start.isAfter(LocalDateTime.now(clock))) {
            throw new BusinessException("Seansam jābūt nākotnē.");
        }
        LocalDateTime end = start.plusMinutes(movie.getDurationMin() + BREAK_MINUTES);
        for (Screening other : screeningDAO.findAllScreenings()) {
            if (other.getHallId() != hallId) {
                continue;
            }
            Movie otherMovie = movieDAO.findById(other.getMovieId());
            int otherMinutes = (otherMovie == null ? 0 : otherMovie.getDurationMin()) + BREAK_MINUTES;
            LocalDateTime otherStart = other.getStartDateTime();
            LocalDateTime otherEnd = otherStart.plusMinutes(otherMinutes);
            if (start.isBefore(otherEnd) && otherStart.isBefore(end)) {
                throw new BusinessException("Zālē šajā laikā jau notiek cits seanss.");
            }
        }
        int id = screeningDAO.addScreening(new Screening(movieId, hallId, date, time, price));
        if (id == -1) {
            throw new BusinessException("Seansu neizdevās pievienot.");
        }
        return id;
    }
}
