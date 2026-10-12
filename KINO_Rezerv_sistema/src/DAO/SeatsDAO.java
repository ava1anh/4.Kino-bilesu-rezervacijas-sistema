/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrejs.Ivaninoks
 */
public class SeatsDAO {
    public int addSeat(Seat seat) {
        String sql = "INSERT INTO seats (seat_number, row_number, is_available) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, seat.getSeatNumber());
            pstmt.setInt(2, seat.getRowNumber());
            pstmt.setBoolean(3, seat.isAvailable());
            return pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating seat failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Seat> findByHall(int hallId) {
        List<Seat> seats = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE hall_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, hallId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat();
                seat.setId(rs.getInt("id"));
                seat.setSeatNumber(rs.getInt("seat_number"));
                seat.setRowNumber(rs.getInt("row_number"));
                seat.setAvailable(rs.getBoolean("is_available"));
                seats.add(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seats;
    }

    public List<Seat> findFreeSeats(int sessionId) {
        List<Seat> freeSeats = new ArrayList<>();
        String sql = "SELECT * FROM seats WHERE session_id = ? AND is_available = true";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, sessionId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat();
                seat.setId(rs.getInt("id"));
                seat.setSeatNumber(rs.getInt("seat_number"));
                seat.setRowNumber(rs.getInt("row_number"));
                seat.setAvailable(rs.getBoolean("is_available"));
                freeSeats.add(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return freeSeats;
    }

    private Seat mapRow(ResultSet rs) throws SQLException {
        Seat seat = new Seat();
        seat.setId(rs.getInt("id"));
        seat.setSeatNumber(rs.getInt("seat_number"));
        seat.setRowNumber(rs.getInt("row_number"));
        seat.setAvailable(rs.getBoolean("is_available"));
        return seat;
    }
}
