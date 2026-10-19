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
import java.util.List;
import Class.Seat;
/**
 *
 * @author Andrejs.Ivaninoks
 */
public class SeatDAO {

    /**
     * Izveido datu piekļuves objektu (savienojums ar datubāzi tiek izveidots katras darbības laikā).
     */
    public SeatDAO() {
    }

    /**
     * Pievieno vienu vietu zālē.
     *
     * @param seat vietas dati (hallId, seatRow, seatNumber)
     * @return jaunās vietas identifikators vai -1 kļūdas gadījumā (piemēram, vieta zālē jau eksistē)
     */
    public int addSeat(Seat seat) {
        String sql = "INSERT INTO seats (hall_id, seat_row, seat_number) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, seat.getHallId());
            ps.setInt(2, seat.getSeatRow());
            ps.setInt(3, seat.getSeatNumber());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return -1;
    }

    /**
     * Atgriež visas zāles vietas, kārtotas pēc rindas un vietas numura.
     *
     * @param hallId zāles identifikators
     * @return vietu saraksts
     */
    public List<Seat> findByHall(int hallId) {
        return query("SELECT * FROM seats WHERE hall_id = ? ORDER BY seat_row, seat_number", hallId);
    }

    /**
     * Atgriež brīvās vietas konkrētā seansā (zāles vietas, kurām nav aktīvas rezervācijas šim seansam).
     *
     * @param screeningId seansa identifikators
     * @return brīvo vietu saraksts
     */
    public List<Seat> findFreeSeats(int screeningId) {
        String sql = "SELECT s.* FROM seats s JOIN screenings sc ON sc.hall_id = s.hall_id "
                + "WHERE sc.id = ? AND s.id NOT IN (SELECT r.seat_id FROM reservations r "
                + "WHERE r.screening_id = sc.id AND r.status = 'ACTIVE') "
                + "ORDER BY s.seat_row, s.seat_number";
        return query(sql, screeningId);
    }

    /**
     * Atrod vietu pēc identifikatora.
     *
     * @param id vietas identifikators
     * @return vieta vai null, ja nav atrasta
     */
    public Seat findById(int id) {
        List<Seat> seats = query("SELECT * FROM seats WHERE id = ?", id);
        return seats.isEmpty() ? null : seats.get(0);
    }

    /**
     * Izveido zālei visas vietas (rindas x vietas rindā).
     *
     * @param hallId zāles identifikators
     * @param rows rindu skaits
     * @param seatsPerRow vietu skaits vienā rindā
     * @return izveidoto vietu skaits vai -1 kļūdas gadījumā
     */
    public int addSeats(int hallId, int rows, int seatsPerRow) {
        String sql = "INSERT INTO seats (hall_id, seat_row, seat_number) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            for (int r = 1; r <= rows; r++) {
                for (int n = 1; n <= seatsPerRow; n++) {
                    ps.setInt(1, hallId);
                    ps.setInt(2, r);
                    ps.setInt(3, n);
                    ps.addBatch();
                }
            }
            ps.executeBatch();
            conn.commit();
            return rows * seatsPerRow;
        } catch (SQLException e) {
            DaoLog.report(e);
            return -1;
        }
    }

    private List<Seat> query(String sql, int param) {
        List<Seat> seats = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, param);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Seat seat = new Seat();
                    seat.setId(rs.getInt("id"));
                    seat.setHallId(rs.getInt("hall_id"));
                    seat.setSeatRow(rs.getInt("seat_row"));
                    seat.setSeatNumber(rs.getInt("seat_number"));
                    seats.add(seat);
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return seats;
    }
}

