/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Reservation;
import model.ReservationView;
/**
 *
 * @author Andrejs.Ivaninoks
 */
public class ReservationDAO {

    /**
     * Izveido datu piekļuves objektu (savienojums ar datubāzi tiek izveidots katras darbības laikā).
     */
    public ReservationDAO() {
    }

    private static final Object LOCK = new Object();

    private static final String VIEW_SQL =
            "SELECT r.id, u.username, m.title, h.name AS hall_name, sc.screening_date, sc.screening_time, "
            + "s.seat_row, s.seat_number, r.status, r.deposit "
            + "FROM reservations r "
            + "JOIN users u ON u.id = r.user_id "
            + "JOIN screenings sc ON sc.id = r.screening_id "
            + "JOIN movies m ON m.id = sc.movie_id "
            + "JOIN halls h ON h.id = sc.hall_id "
            + "JOIN seats s ON s.id = r.seat_id ";

    /**
     * Izveido jaunu rezervāciju. Pārbaude "vai vieta brīva" un ieraksta izveide notiek vienā transakcijā, tāpēc
     * vienu un to pašu vietu seansā nevar rezervēt divreiz (atceltās rezervācijas vietu neaizņem).
     *
     * @param reservation rezervācijas dati (userId, screeningId, seatId, status, deposit)
     * @return jaunās rezervācijas identifikators vai -1, ja vieta jau ir aizņemta vai radusies kļūda
     */
    public int createReservation(Reservation reservation) {
        String insert = "INSERT INTO reservations (user_id, screening_id, seat_id, status, deposit) "
                + "VALUES (?, ?, ?, ?, ?)";
        synchronized (LOCK) {
            try (Connection conn = DatabaseManager.getConnection()) {
                conn.setAutoCommit(false);
                try {
                    if (isSeatTaken(conn, reservation.getScreeningId(), reservation.getSeatId())) {
                        conn.rollback();
                        return -1;
                    }
                    try (PreparedStatement ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
                        ps.setInt(1, reservation.getUserId());
                        ps.setInt(2, reservation.getScreeningId());
                        ps.setInt(3, reservation.getSeatId());
                        ps.setString(4, reservation.getStatus());
                        ps.setBigDecimal(5, reservation.getDeposit());
                        ps.executeUpdate();
                        try (ResultSet keys = ps.getGeneratedKeys()) {
                            keys.next();
                            int id = keys.getInt(1);
                            conn.commit();
                            return id;
                        }
                    }
                } catch (SQLException e) {
                    conn.rollback();
                    throw e;
                }
            } catch (SQLException e) {
                DaoLog.report(e);
                return -1;
            }
        }
    }

    /**
     * Atrod rezervāciju pēc identifikatora.
     *
     * @param id rezervācijas identifikators
     * @return rezervācija vai null, ja nav atrasta
     */
    public Reservation findById(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return null;
    }

    /**
     * Nomaina rezervācijas statusu (piemēram, uz CANCELED).
     *
     * @param id rezervācijas identifikators
     * @param status jaunais statuss (ACTIVE vai CANCELED)
     * @return true, ja statuss tika nomainīts
     */
    public boolean updateStatus(int id, String status) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE reservations SET status = ? WHERE id = ?")) {
            ps.setString(1, status);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            DaoLog.report(e);
            return false;
        }
    }

    /**
     * Pārbauda, vai vietai konkrētajā seansā ir aktīva rezervācija.
     *
     * @param screeningId seansa identifikators
     * @param seatId vietas identifikators
     * @return true, ja vieta ir aizņemta
     */
    public boolean isSeatTaken(int screeningId, int seatId) {
        try (Connection conn = DatabaseManager.getConnection()) {
            return isSeatTaken(conn, screeningId, seatId);
        } catch (SQLException e) {
            DaoLog.report(e);
            return true;
        }
    }

    /**
     * Atgriež seansā aizņemto vietu identifikatorus (tikai aktīvās rezervācijas).
     *
     * @param screeningId seansa identifikators
     * @return aizņemto vietu identifikatoru kopa
     */
    public Set<Integer> findTakenSeatIds(int screeningId) {
        Set<Integer> ids = new HashSet<>();
        String sql = "SELECT seat_id FROM reservations WHERE screening_id = ? AND status = 'ACTIVE'";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, screeningId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ids.add(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return ids;
    }

    /**
     * Atgriež lietotāja rezervācijas, jaunākās pirmās (pirkumu vēsture, funkcija T6).
     *
     * @param userId lietotāja identifikators
     * @return rezervāciju saraksts
     */
    public List<Reservation> findByUser(int userId) {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE user_id = ? ORDER BY created_at DESC, id DESC";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return list;
    }

    /**
     * Atgriež lietotāja rezervācijas kopā ar filmas, zāles un vietas datiem attēlošanai tabulā.
     *
     * @param userId lietotāja identifikators
     * @return rezervāciju attēlošanas saraksts
     */
    public List<ReservationView> findViewsByUser(int userId) {
        return queryViews("WHERE r.user_id = ? ", userId, true);
    }

    /**
     * Atgriež visas sistēmas rezervācijas (administratora skats).
     *
     * @return rezervāciju attēlošanas saraksts
     */
    public List<ReservationView> findAllViews() {
        return queryViews("", 0, false);
    }

    private List<ReservationView> queryViews(String where, int userId, boolean hasParam) {
        List<ReservationView> list = new ArrayList<>();
        String sql = VIEW_SQL + where + "ORDER BY sc.screening_date DESC, sc.screening_time DESC, r.id DESC";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (hasParam) {
                ps.setInt(1, userId);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ReservationView v = new ReservationView();
                    v.setId(rs.getInt("id"));
                    v.setUsername(rs.getString("username"));
                    v.setMovieTitle(rs.getString("title"));
                    v.setHallName(rs.getString("hall_name"));
                    v.setDate(rs.getDate("screening_date").toLocalDate());
                    v.setTime(rs.getTime("screening_time").toLocalTime());
                    v.setSeatRow(rs.getInt("seat_row"));
                    v.setSeatNumber(rs.getInt("seat_number"));
                    v.setStatus(rs.getString("status"));
                    v.setDeposit(rs.getBigDecimal("deposit"));
                    list.add(v);
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return list;
    }

    private boolean isSeatTaken(Connection conn, int screeningId, int seatId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM reservations WHERE screening_id = ? AND seat_id = ? AND status = 'ACTIVE'";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, screeningId);
            ps.setInt(2, seatId);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }

    private Reservation mapRow(ResultSet rs) throws SQLException {
        Reservation r = new Reservation();
        r.setId(rs.getInt("id"));
        r.setUserId(rs.getInt("user_id"));
        r.setScreeningId(rs.getInt("screening_id"));
        r.setSeatId(rs.getInt("seat_id"));
        r.setStatus(rs.getString("status"));
        r.setDeposit(rs.getBigDecimal("deposit"));
        r.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return r;
    }
}
