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
import model.User;
import util.PasswordUtil;
/**
 *
 * @author Andrejs.Ivaninoks
 */
public class UserDAO {

    /**
     * Izveido datu piekļuves objektu (savienojums ar datubāzi tiek izveidots katras darbības laikā).
     */
    public UserDAO() {
    }

    /**
     * Reģistrē jaunu lietotāju (funkcija T2). Parole tiek saglabāta kā SHA-256 jaucējkods.
     *
     * @param user jaunā lietotāja dati (identifikators un paroles jaucējkods netiek izmantoti)
     * @param password parole atklātā tekstā
     * @return jaunā lietotāja identifikators vai -1, ja lietotājvārds vai e-pasts jau eksistē / radusies kļūda
     */
    public int register(User user, String password) {
        String sql = "INSERT INTO users (first_name, last_name, username, email, password_hash, role) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getEmail());
            ps.setString(5, PasswordUtil.hash(password));
            ps.setString(6, user.getRole() == null ? User.ROLE_CUSTOMER : user.getRole());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            if (!"23505".equals(e.getSQLState())) { // 23505 = lietotājvārds vai e-pasts jau eksistē
                DaoLog.report(e);
            }
        }
        return -1;
    }

    /**
     * Pārbauda lietotājvārdu un paroli (funkcija T1).
     *
     * @param username lietotājvārds
     * @param password parole atklātā tekstā
     * @return pieslēgušais lietotājs vai null, ja dati nav pareizi
     */
    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password_hash = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hash(password));
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
     * Atrod lietotāju pēc identifikatora.
     *
     * @param id lietotāja identifikators
     * @return lietotājs vai null, ja nav atrasts
     */
    public User findById(int id) {
        return findOne("SELECT * FROM users WHERE id = ?", id, null);
    }

    /**
     * Atrod lietotāju pēc lietotājvārda.
     *
     * @param username lietotājvārds
     * @return lietotājs vai null, ja nav atrasts
     */
    public User findByUsername(String username) {
        return findOne("SELECT * FROM users WHERE username = ?", 0, username);
    }

    /**
     * Atgriež visus sistēmas lietotājus, kārtotus pēc lietotājvārda.
     *
     * @return lietotāju saraksts (tukšs, ja lietotāju nav)
     */
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY username";
        try (Connection conn = DatabaseManager.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                users.add(mapRow(rs));
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return users;
    }

    /**
     * Atjaunina lietotāja vārdu, uzvārdu, e-pastu un lomu.
     *
     * @param user lietotājs ar jauniem datiem (jānorāda identifikators)
     * @return true, ja ieraksts tika atjaunināts
     */
    public boolean update(User user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, role = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getRole());
            ps.setInt(5, user.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            DaoLog.report(e);
            return false;
        }
    }

    /**
     * Dzēš lietotāju pēc identifikatora (kopā ar viņa rezervācijām, pateicoties ON DELETE CASCADE).
     *
     * @param id lietotāja identifikators
     * @return true, ja lietotājs tika dzēsts
     */
    public boolean delete(int id) {
        return executeDelete("DELETE FROM users WHERE id = ?", id, null);
    }

    /**
     * Dzēš lietotāju pēc lietotājvārda (atvieglo testu rakstīšanu).
     *
     * @param username lietotājvārds
     * @return true, ja lietotājs tika dzēsts
     */
    public boolean deleteUser(String username) {
        return executeDelete("DELETE FROM users WHERE username = ?", 0, username);
    }

    /**
     * Pārbauda, vai lietotājvārds jau ir aizņemts.
     *
     * @param username lietotājvārds
     * @return true, ja lietotājs ar šādu lietotājvārdu jau eksistē
     */
    public boolean existsByUsername(String username) {
        return findByUsername(username) != null;
    }

    private User findOne(String sql, int id, String text) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (text == null) {
                ps.setInt(1, id);
            } else {
                ps.setString(1, text);
            }
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

    private boolean executeDelete(String sql, int id, String text) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (text == null) {
                ps.setInt(1, id);
            } else {
                ps.setString(1, text);
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            DaoLog.report(e);
            return false;
        }
    }

    private User mapRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
