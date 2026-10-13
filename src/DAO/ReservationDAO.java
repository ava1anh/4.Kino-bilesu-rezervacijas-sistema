/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrejs.Ivaninoks
 */
public class ReservationDAO {

    public int creatReservation(Reservation reservation) {
        String sql = "INSERT INTO RESERVATIONS(user_id, session_id, seat_id, statuss, iemaksa) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, reservation.getUserId());
            pstmt.setInt(2, reservation.getSessionId());
            pstmt.setInt(3, reservation.getSeatId());
            pstmt.setString(4, reservation.getStatus());
            pstmt.setBigDecimal(5, reservation.getIemaksa());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating reservation failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating reservation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean cancelReservation(int reservationId) {
        String sql = "UPDATE RESERVATIONS SET statuss = 'canceled' WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reservationId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cancelReservationAdmin(int reservationId) {
        String sql = "UPDATE RESERVATIONS SET statuss = 'canceled' WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reservationId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reservation> findByUser(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM RESERVATIONS WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setId(rs.getInt("id"));
                    reservation.setUserId(rs.getInt("user_id"));
                    reservation.setSessionId(rs.getInt("session_id"));
                    reservation.setSeatId(rs.getInt("seat_id"));
                    reservation.setStatuss(rs.getString("statuss"));
                    reservation.setIemaksa(rs.getBigDecimal("iemaksa"));
                    reservation.setIzveidesLaiks(rs.getTimestamp("izveides_laiks"));
                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}





