package util;

import db.DatabaseManager;

/**
 * Palīgklase testiem: pārslēdz programmu uz atsevišķu testa datubāzi (mape build/test-db),
 * lai testi neizmainītu lietotnes īstos datus mapē database.
 */
public final class TestDb {

    private TestDb() {
    }

    /**
     * Izvēlas testa datubāzi un inicializē to (izveido tabulas un sākuma datus, ja vajag).
     */
    public static void setUp() {
        DatabaseManager.useDatabase("build/test-db/appdb");
        DatabaseManager.init();
    }
}
