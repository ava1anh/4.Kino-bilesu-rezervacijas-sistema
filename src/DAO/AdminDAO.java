/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Class.Admin;
import java.sql.*;
/**
 *
 * @author Andrejs.Ivaninoks
 */

/**
 * Nodrošina darbības ar tabulu ADMIN, kas satur papildu tiesības konkrētam lietotājam (User ar lomu "administrators").
 */
public class AdminDAO {

    /**
     * Piešķir lietotājam administratora tiesības.
     */
    public int addAdmin(Admin admin){
        String sql = "INSERT INTO ADMIN (user_id tiesibas) VALUES(?, ?)";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, admin.getUserId());
            ps.setString(2, admin.getTiesibas());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        }
        catch (SQLException e) {
            System.err.println("Kļūda piešķirot administratora tiesības: " + e.getMessage());
        }
        return -1;
    }
    
    /**
    * Pārbauda, vai konkrētajam lietotājam ir administratora tiesības, un atgriež tās.
    */
    public Admin findByUserId(int userId) {
        String sql = "SELECT * FROM ADMIN WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Admin a = new Admin();
                    a.setId(rs.getInt("id"));
                    a.setUserId(rs.getInt("user_id"));
                    a.setTiesibas(rs.getString("tiesibas"));
                    return a;
                }
            }
        } catch (SQLException e) {
            System.err.println("Kļūda meklējot administratoru: " + e.getMessage());
        }
        return null;
    }
}

