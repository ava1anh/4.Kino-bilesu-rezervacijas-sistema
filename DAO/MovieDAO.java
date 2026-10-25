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
import model.Movie;
/**
 *
 * @author Andrejs.Ivaninoks
 */
public class MovieDAO {

    /**
     * Izveido datu piekļuves objektu (savienojums ar datubāzi tiek izveidots katras darbības laikā).
     */
    public MovieDAO() {
    }

    /**
     * Pievieno jaunu filmu.
     *
     * @param movie filmas dati
     * @return jaunās filmas identifikators vai -1 kļūdas gadījumā
     */
    public int addMovie(Movie movie) {
        String sql = "INSERT INTO movies (title, genre, duration_min, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDurationMin());
            ps.setString(4, movie.getDescription());
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
     * Atgriež visas filmas, kārtotas pēc nosaukuma.
     *
     * @return filmu saraksts (tukšs, ja filmu nav)
     */
    public List<Movie> findAllMovies() {
        return query("SELECT * FROM movies ORDER BY title", null);
    }

    /**
     * Atrod filmu pēc identifikatora.
     *
     * @param id filmas identifikators
     * @return filma vai null, ja nav atrasta
     */
    public Movie findById(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM movies WHERE id = ?")) {
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
     * Meklē filmas pēc nosaukuma vai žanra fragmenta (lielie un mazie burti netiek šķirti).
     *
     * @param criterion meklējamais teksts
     * @return atrasto filmu saraksts
     */
    public List<Movie> search(String criterion) {
        String pattern = "%" + (criterion == null ? "" : criterion.trim().toLowerCase()) + "%";
        return query("SELECT * FROM movies WHERE LOWER(title) LIKE ? OR LOWER(genre) LIKE ? ORDER BY title", pattern);
    }

    /**
     * Atjaunina filmas datus.
     *
     * @param movie filma ar jauniem datiem (jānorāda identifikators)
     * @return true, ja ieraksts tika atjaunināts
     */
    public boolean updateMovie(Movie movie) {
        String sql = "UPDATE movies SET title = ?, genre = ?, duration_min = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDurationMin());
            ps.setString(4, movie.getDescription());
            ps.setInt(5, movie.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            DaoLog.report(e);
            return false;
        }
    }

    /**
     * Dzēš filmu kopā ar tās seansiem un to rezervācijām (ON DELETE CASCADE).
     *
     * @param id filmas identifikators
     * @return true, ja filma tika dzēsta
     */
    public boolean deleteMovie(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM movies WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            DaoLog.report(e);
            return false;
        }
    }

    private List<Movie> query(String sql, String pattern) {
        List<Movie> movies = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (pattern != null) {
                ps.setString(1, pattern);
                ps.setString(2, pattern);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    movies.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            DaoLog.report(e);
        }
        return movies;
    }

    private Movie mapRow(ResultSet rs) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getInt("id"));
        movie.setTitle(rs.getString("title"));
        movie.setGenre(rs.getString("genre"));
        movie.setDurationMin(rs.getInt("duration_min"));
        movie.setDescription(rs.getString("description"));
        return movie;
    }
}

