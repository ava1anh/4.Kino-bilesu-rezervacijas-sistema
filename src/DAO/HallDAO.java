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
import Class.Hall;
/**
 *
 * @author Andrejs.Ivaninoks
 */
public class HallDAO {

    /**
     * Izveido datu piekļuves objektu (savienojums ar datubāzi tiek izveidots katras darbības laikā).
     */
    public HallDAO() {
    }

    /**
     * Pievieno jaunu zāli.
     *
     * @param hall zāles dati
     * @return jaunās zāles identifikators vai -1 kļūdas gadījumā (piemēram, nosaukums jau eksistē)
     */
    public int addHall(Hall hall) {
        String sql = "INSERT INTO hall (name, seat_count) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, hall.getName());
            ps.setInt(2, hall.getSeatCount());
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
     * Atgriež visas zāles, kārtotas pēc nosaukuma.
     *
     * @return zāļu saraksts
     */
    public List<Hall> findAllHalls() {
        List<Hall> halls = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM hall ORDER BY name")) {
            while (rs.next()) {
                halls.add(mapRow(rs));
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return halls;
    }

    /**
     * Atrod zāli pēc identifikatora.
     *
     * @param id zāles identifikators
     * @return zāle vai null, ja nav atrasta
     */
    public Hall findById(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM halls WHERE id = ?")) {
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
     * Dzēš zāli kopā ar tās vietām un seansiem (ON DELETE CASCADE).
     *
     * @param id zāles identifikators
     * @return true, ja zāle tika dzēsta
     */
    public boolean deleteHall(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM halls WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            DaoLog.report(e);
            return false;
        }
    }

    private Hall mapRow(ResultSet rs) throws SQLException {
        Hall hall = new Hall();
        hall.setId(rs.getInt("id"));
        hall.setName(rs.getString("name"));
        hall.setSeatCount(rs.getInt("seat_count"));
        return hall;
    }
}

