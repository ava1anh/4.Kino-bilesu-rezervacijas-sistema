/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.SQLException;
/**
 *
 * @author andre
 */
final class DaoLog {

    private DaoLog() {
    }

    /**
     * Izvada datu bāzes kļūdu konsolē.
     *
     * @param e datu bāzes izņēmums
     */
    static void report(SQLException e) {
        String state = e.getSQLState();
        if (state != null && state.startsWith("23")) {
            System.err.println("Datu integritātes ierobežojums pārkāpts (" + state + "): " + e.getMessage());
        } else {
            e.printStackTrace();
        }
    }
}
