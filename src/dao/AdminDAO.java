package dao;

import db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Admin;

/**
 * Datu piekļuves klase darbam ar tabulu ADMINS, kas satur papildu tiesības lietotājam ar lomu admin.
 */
public class AdminDAO {

    /**
     * Izveido datu piekļuves objektu (savienojums ar datubāzi tiek izveidots katras darbības laikā).
     */
    public AdminDAO() {
    }

    /**
     * Piešķir lietotājam administratora tiesības.
     *
     * @param admin administratora dati (userId un rights)
     * @return jaunā ieraksta identifikators vai -1 kļūdas gadījumā
     */
    public int addAdmin(Admin admin) {
        String sql = "INSERT INTO admins (user_id, rights) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, admin.getUserId());
            ps.setString(2, admin.getRights());
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
     * Atrod lietotāja administratora tiesības.
     *
     * @param userId lietotāja identifikators
     * @return administratora ieraksts vai null, ja lietotājam nav administratora tiesību
     */
    public Admin findByUserId(int userId) {
        String sql = "SELECT * FROM admins WHERE user_id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Admin admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setUserId(rs.getInt("user_id"));
                    admin.setRights(rs.getString("rights"));
                    return admin;
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return null;
    }
}
