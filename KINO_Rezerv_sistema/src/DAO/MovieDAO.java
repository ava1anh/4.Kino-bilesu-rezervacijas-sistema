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
public class MovieDAO {
    
    public int addMovie(Movie movie) {
        String sql = "INSERT INTO MOVIES(nosaukums, zanrs, ilgums, apraksts) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, movie.getNosaukums());
            pstmt.setString(2, movie.getZanrs());
            pstmt.setInt(3, movie.getIlgums());
            pstmt.setString(4, movie.getApraksts());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating movie failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating movie failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Movie> findAllMovies() {
        List<Movie> results = new ArrayList<>();
        String sql = "SELECT * FROM MOVIES";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setNosaukums(rs.getString("nosaukums"));
                movie.setZanrs(rs.getString("zanrs"));
                movie.setIlgums(rs.getInt("ilgums"));
                movie.setApraksts(rs.getString("apraksts"));
                results.add(movie);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching movies: " + e.getMessage());
        }
        return results
        ;
    }

    public List<Movie> search(String criterion) {
        List<Movie> results = new ArrayList<>();
        String sql = "SELECT * FROM MOVIES WHERE nosaukums LIKE ? OR zanrs LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String searchPattern = "%" + criterion + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getInt("id"));
                    movie.setNosaukums(rs.getString("nosaukums"));
                    movie.setZanrs(rs.getString("zanrs"));
                    movie.setIlgums(rs.getInt("ilgums"));
                    movie.setApraksts(rs.getString("apraksts"));
                    results.add(movie);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while searching movies: " + e.getMessage());
        }
        return results;
    }   

    public boolean updateMovie(Movie movie) {
        String sql = "UPDATE MOVIES SET nosaukums = ?, zanrs = ?, ilgums = ?, apraksts = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie.getNosaukums());
            pstmt.setString(2, movie.getZanrs());
            pstmt.setInt(3, movie.getIlgums());
            pstmt.setString(4, movie.getApraksts());
            pstmt.setInt(5, movie.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error while updating movie: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteMovie(int id) {
        String sql = "DELETE FROM MOVIES WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error while deleting movie: " + e.getMessage());
            return false;
        }
    }

    private Movie mapRow(ResultSet rs) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getInt("id"));
        movie.setNosaukums(rs.getString("nosaukums"));
        movie.setZanrs(rs.getString("zanrs"));
        movie.setIlgums(rs.getInt("ilgums"));
        movie.setApraksts(rs.getString("apraksts"));
        return movie;
    }
}