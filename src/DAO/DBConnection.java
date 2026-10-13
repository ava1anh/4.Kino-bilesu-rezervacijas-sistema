/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Andrejs Ivaninoks
 */

/**
 * Nodrošina vienotu savienojumu ar Apache Derby Embedded datu bāzi.
 * Datu bāze tiek izveidota automātiski.
 */
public class DBConnection {
    
    private static final String DB_URL = "jdbc:derby:KinoDB;create=true";
    private static Connection connection;
    
    private DBConnection() {
    }

    /**
    * Atgriež aktīvu savienojumu ar datu bāzi. Ja savienojuma vēl nav.
    */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL);
        }
        return connection;
    } 
    
    /**
     * Aizver aktīvo savienojumu ar datu bāzi.
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Kļūda aizverot savienojumu: " + e.getMessage());
        }
    }    
}
