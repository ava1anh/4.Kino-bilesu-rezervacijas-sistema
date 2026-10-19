/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import db.DatabaseManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import Class.Screening;
/**
 *
 * @author Andrejs.Ivaninoks
 */
public class ScreeningDAO {

    /**
     * Izveido datu piekļuves objektu (savienojums ar datubāzi tiek izveidots katras darbības laikā).
     */
    public ScreeningDAO() {
    }

    /**
     * Izveido jaunu seansu.
     *
     * @param screening seansa dati (movieId, hallId, date, time, price)
     * @return jaunā seansa identifikators vai -1 kļūdas gadījumā
     */
    public int addScreening(Screening screening) {
        String sql = "INSERT INTO screenings (movie_id, hall_id, screening_date, screening_time, price) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, screening.getMovieId());
            ps.setInt(2, screening.getHallId());
            ps.setDate(3, Date.valueOf(screening.getDate()));
            ps.setTime(4, Time.valueOf(screening.getTime()));
            ps.setBigDecimal(5, screening.getPrice());
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
     * Atgriež visus seansus, kārtotus pēc datuma un laika.
     *
     * @return seansu saraksts
     */
    public List<Screening> findAllScreenings() {
        return query("SELECT * FROM screenings ORDER BY screening_date, screening_time", 0, false);
    }

    /**
     * Atgriež konkrētas filmas seansus, kārtotus pēc datuma un laika.
     *
     * @param movieId filmas identifikators
     * @return seansu saraksts
     */
    public List<Screening> findByMovie(int movieId) {
        return query("SELECT * FROM screenings WHERE movie_id = ? ORDER BY screening_date, screening_time",
                movieId, true);
    }

    /**
     * Atrod seansu pēc identifikatora.
     *
     * @param id seansa identifikators
     * @return seanss vai null, ja nav atrasts
     */
    public Screening findById(int id) {
        List<Screening> result = query("SELECT * FROM screenings WHERE id = ?", id, true);
        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * Atceļ (dzēš) seansu kopā ar tā rezervācijām (ON DELETE CASCADE).
     *
     * @param id seansa identifikators
     * @return true, ja seanss tika dzēsts
     */
    public boolean cancelScreening(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM screenings WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            DaoLog.report(e);
            return false;
        }
    }

    private List<Screening> query(String sql, int param, boolean hasParam) {
        List<Screening> screenings = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (hasParam) {
                ps.setInt(1, param);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Screening s = new Screening();
                    s.setId(rs.getInt("id"));
                    s.setMovieId(rs.getInt("movie_id"));
                    s.setHallId(rs.getInt("hall_id"));
                    s.setDate(rs.getDate("screening_date").toLocalDate());
                    s.setTime(rs.getTime("screening_time").toLocalTime());
                    s.setPrice(rs.getBigDecimal("price"));
                    screenings.add(s);
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return screenings;
    }
}

