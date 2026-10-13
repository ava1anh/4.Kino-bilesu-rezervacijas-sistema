/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.beans.*;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author Andrejs Ivaninoks
 */


/**
* Izveido visas sistēmas tabulas (USERS, ADMIN, MOVIES, HALLS,
* SEATS, SESSIONS, RESERVATIONS) kopā ar ārējām atslēgām.
*/
public class Database {
    public static void initialize() {
        createTable("CREATE TABLE USERS ("
                + "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "vards VARCHAR(50),"
                + "uzvards VARCHAR(50),"
                + "lietotajvards VARCHAR(30) NOT NULL UNIQUE,"
                + "parole_hash VARCHAR(64) NOT NULL,"
                + "epasts VARCHAR(100) NOT NULL UNIQUE,"
                + "loma VARCHAR(20) NOT NULL DEFAULT 'klients',"
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

        createTable("CREATE TABLE ADMIN ("
                + "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "user_id INTEGER NOT NULL UNIQUE,"
                + "tiesibas VARCHAR(100),"
                + "FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE)");

        createTable("CREATE TABLE MOVIES ("
                + "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "nosaukums VARCHAR(100) NOT NULL,"
                + "zanrs VARCHAR(50),"
                + "ilgums_min INTEGER,"
                + "apraksts VARCHAR(500))");

        createTable("CREATE TABLE HALLS ("
                + "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "nosaukums VARCHAR(50) NOT NULL,"
                + "vietu_skaits INTEGER NOT NULL)");

        createTable("CREATE TABLE SEATS ("
                + "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "hall_id INTEGER NOT NULL,"
                + "rinda INTEGER NOT NULL,"
                + "vieta_nr INTEGER NOT NULL,"
                + "FOREIGN KEY (hall_id) REFERENCES HALLS(id) ON DELETE CASCADE)");

        createTable("CREATE TABLE SESSIONS ("
                + "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "movie_id INTEGER NOT NULL,"
                + "hall_id INTEGER NOT NULL,"
                + "datums DATE NOT NULL,"
                + "laiks TIME NOT NULL,"
                + "cena DECIMAL(6,2) NOT NULL,"
                + "FOREIGN KEY (movie_id) REFERENCES MOVIES(id) ON DELETE CASCADE,"
                + "FOREIGN KEY (hall_id) REFERENCES HALLS(id) ON DELETE CASCADE)");

        createTable("CREATE TABLE RESERVATIONS ("
                + "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "user_id INTEGER NOT NULL,"
                + "session_id INTEGER NOT NULL,"
                + "seat_id INTEGER NOT NULL,"
                + "statuss VARCHAR(20) NOT NULL DEFAULT 'aktiva',"
                + "iemaksa DECIMAL(4,2) NOT NULL DEFAULT 1.00,"
                + "izveides_laiks TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE,"
                + "FOREIGN KEY (session_id) REFERENCES SESSIONS(id) ON DELETE CASCADE,"
                + "FOREIGN KEY (seat_id) REFERENCES SEATS(id) ON DELETE CASCADE,"
                + "UNIQUE (session_id, seat_id))");    
    }
    private static void createTable(String sql) {
        try (Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            if (!"X0Y32".equals(e.getSQLState())) {
                System.err.println("Kļūda veidojot tabulu: " + e.getMessage());
            }
        }
    }
}
