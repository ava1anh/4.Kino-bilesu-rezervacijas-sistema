/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class HallDAO {
    public int addHall(Hall hall) {
        String sql = "INSERT INTO HALLS(nosaukums, vietu_skaits) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, hall.getNosaukums());
            pstmt.setInt(2, hall.getVietuSkaits());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating hall failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating hall failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Hall> getAllHalls() {
        List<Hall> halls = new ArrayList<>();
        String sql = "SELECT * FROM HALLS";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Hall hall = new Hall();
                hall.setId(rs.getInt("id"));
                hall.setNosaukums(rs.getString("nosaukums"));
                hall.setVietuSkaits(rs.getInt("vietu_skaits"));
                halls.add(hall);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return halls;
    }
}
