package dao;

import java.sql.SQLException;

/**
 * Palīgklase datu bāzes kļūdu izvadīšanai konsolē: paredzamos datu integritātes pārkāpumus (SQLSTATE 23xxx,
 * piemēram, dublēta atslēga vai CHECK ierobežojums) izvada vienā rindā, pārējās kļūdas - ar pilnu steka izsekojumu.
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
