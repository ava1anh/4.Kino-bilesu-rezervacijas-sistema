/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.Sessionn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andrejs.Ivaninoks
 */
public class SessionDAO {
    public int addSession(Sessionn session) {
        String sql = "INSERT INTO sessions (movie_id, hall_id, date, time , price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, session.getMovieId());
            pstmt.setInt(2, session.getHallId());
            pstmt.setTimestamp(3, new java.sql.Timestamp(session.getTime().getTime()));
            pstmt.setDouble(4, session.getPrice());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating session failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating session failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Sessionn> findAllSessions() {
        List<Sessionn> sessions = new ArrayList<>();
        String sql = "SELECT * FROM sessions";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Sessionn session = new Sessionn();
                session.setId(rs.getInt("id"));
                session.setMovieId(rs.getInt("movie_id"));
                session.setHallId(rs.getInt("hall_id"));
                session.setTime(rs.getTimestamp("date"));
                session.setPrice(rs.getDouble("price"));
                sessions.add(session);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }

     public List<Sessionn> findByMovie(int movieId) {
        List<Sessionn> sessions = new ArrayList<>();
        String sql = "SELECT * FROM sessions WHERE movie_id = ? ORDER BY date, time";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, movieId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Sessionn session = new Sessionn();
                session.setId(rs.getInt("id"));
                session.setMovieId(rs.getInt("movie_id"));
                session.setHallId(rs.getInt("hall_id"));
                session.setTime(rs.getTimestamp("date"));
                session.setPrice(rs.getDouble("price"));
                sessions.add(session);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }

    public boolean cancelSession(int id) {
        String sql = "DELETE FROM sessions WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Sessionn mapRow(ResultSet rs) throws SQLException {
        Sessionn session = new Sessionn();
        session.setId(rs.getInt("id"));
        session.setMovieId(rs.getInt("movie_id"));
        session.setHallId(rs.getInt("hall_id"));
        session.setTime(rs.getTimestamp("date"));
        session.setPrice(rs.getDouble("price"));
        return session;
    }
}
