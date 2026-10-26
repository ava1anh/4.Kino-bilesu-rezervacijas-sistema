package db;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import util.PasswordUtil;

public class DatabaseManager {

    /** Noklusētais relatīvais ceļš uz datubāzi. */
    public static final String DEFAULT_DB_PATH = "database/appdb";

    /** Noklusētais administratora lietotājvārds (izveidojas pirmajā palaišanā). */
    public static final String DEFAULT_ADMIN_USERNAME = "admin";

    /** Noklusētā administratora parole (izveidojas pirmajā palaišanā). */
    public static final String DEFAULT_ADMIN_PASSWORD = "admin123";

    private static String dbPath = DEFAULT_DB_PATH;
    private static boolean logConfigured = false;

    private DatabaseManager() {
    }

    /**
     * Norāda, kuru datubāzi izmantot (piemēram, testiem atsevišķu datubāzi). Jāizsauc pirms {@link #init()}.
     *
     * @param path relatīvs ceļš uz datubāzes mapi
     */
    public static synchronized void useDatabase(String path) {
        dbPath = path;
        logConfigured = false;
    }

    /**
     * Atgriež jaunu savienojumu ar datubāzi. Ja datubāzes vēl nav, tā tiek izveidota.
     *
     * @return savienojums ar datubāzi (to jāaizver izsaucējam)
     * @throws SQLException ja savienojumu neizdodas izveidot
     */
    public static Connection getConnection() throws SQLException {
        configureLog();
        return DriverManager.getConnection("jdbc:derby:" + dbPath + ";create=true");
    }

    /**
     * Izveido tabulas, ja tās vēl neeksistē, un ievieto sākuma datus, ja datubāze ir tukša.
     *
     * @throws IllegalStateException ja datubāzi neizdodas inicializēt
     */
    public static synchronized void init() {
        try (Connection conn = getConnection()) {
            DatabaseMetaData meta = conn.getMetaData();
            createTables(conn, meta);
            seedDefaultData(conn);
        } catch (SQLException e) {
            throw new IllegalStateException("Neizdevās inicializēt datubāzi: " + e.getMessage(), e);
        }
    }

    /**
     * Korekti aizver datubāzi (jāizsauc, aizverot programmu).
     */
    public static synchronized void shutdown() {
        try {
            DriverManager.getConnection("jdbc:derby:" + dbPath + ";shutdown=true");
        } catch (SQLException e) {
            // Derby vienmēr izmet izņēmumu 08006, kad atsevišķa datubāze tiek veiksmīgi aizvērta.
            if (!"08006".equals(e.getSQLState())) {
                System.err.println("Kļūda aizverot datubāzi: " + e.getMessage());
            }
        }
    }

    /**
     * Ievieto Derby žurnāla failu (derby.log) datubāzes mapes vecākmapē, lai projekta mape paliktu tīra.
     */
    private static void configureLog() {
        if (!logConfigured) {
            File parent = new File(dbPath).getAbsoluteFile().getParentFile();
            if (parent != null) {
                parent.mkdirs();
                System.setProperty("derby.stream.error.file", new File(parent, "derby.log").getPath());
            }
            logConfigured = true;
        }
    }

    private static boolean tableExists(DatabaseMetaData meta, String table) throws SQLException {
        try (ResultSet rs = meta.getTables(null, null, table, null)) {
            return rs.next();
        }
    }

    private static void createIfMissing(Connection conn, DatabaseMetaData meta, String table, String sql)
            throws SQLException {
        if (!tableExists(meta, table)) {
            try (Statement st = conn.createStatement()) {
                st.executeUpdate(sql);
            }
        }
    }

    /**
     * Izveido visas sistēmas tabulas ar primārajām un ārējām atslēgām un ierobežojumiem.
     */
    private static void createTables(Connection conn, DatabaseMetaData meta) throws SQLException {
        createIfMissing(conn, meta, "USERS",
                "CREATE TABLE users ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "first_name VARCHAR(50) NOT NULL, "
                + "last_name VARCHAR(50) NOT NULL, "
                + "username VARCHAR(30) NOT NULL UNIQUE, "
                + "email VARCHAR(100) NOT NULL UNIQUE, "
                + "password_hash VARCHAR(64) NOT NULL, "
                + "role VARCHAR(20) NOT NULL DEFAULT 'customer' CHECK (role IN ('customer', 'admin')), "
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

        createIfMissing(conn, meta, "ADMINS",
                "CREATE TABLE admins ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "user_id INT NOT NULL UNIQUE, "
                + "rights VARCHAR(100), "
                + "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE)");

        createIfMissing(conn, meta, "MOVIES",
                "CREATE TABLE movies ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "title VARCHAR(100) NOT NULL, "
                + "genre VARCHAR(50), "
                + "duration_min INT CHECK (duration_min > 0), "
                + "description VARCHAR(500))");

        createIfMissing(conn, meta, "HALLS",
                "CREATE TABLE halls ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "name VARCHAR(50) NOT NULL UNIQUE, "
                + "seat_count INT NOT NULL CHECK (seat_count > 0))");

        createIfMissing(conn, meta, "SEATS",
                "CREATE TABLE seats ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "hall_id INT NOT NULL, "
                + "seat_row INT NOT NULL CHECK (seat_row > 0), "
                + "seat_number INT NOT NULL CHECK (seat_number > 0), "
                + "FOREIGN KEY (hall_id) REFERENCES halls(id) ON DELETE CASCADE, "
                + "UNIQUE (hall_id, seat_row, seat_number))");

        createIfMissing(conn, meta, "SCREENINGS",
                "CREATE TABLE screenings ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "movie_id INT NOT NULL, "
                + "hall_id INT NOT NULL, "
                + "screening_date DATE NOT NULL, "
                + "screening_time TIME NOT NULL, "
                + "price DECIMAL(6,2) NOT NULL CHECK (price > 0), "
                + "FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE, "
                + "FOREIGN KEY (hall_id) REFERENCES halls(id) ON DELETE CASCADE)");

        createIfMissing(conn, meta, "RESERVATIONS",
                "CREATE TABLE reservations ("
                + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                + "user_id INT NOT NULL, "
                + "screening_id INT NOT NULL, "
                + "seat_id INT NOT NULL, "
                + "status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'CANCELED')), "
                + "deposit DECIMAL(4,2) NOT NULL DEFAULT 1.00, "
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE, "
                + "FOREIGN KEY (screening_id) REFERENCES screenings(id) ON DELETE CASCADE, "
                + "FOREIGN KEY (seat_id) REFERENCES seats(id) ON DELETE CASCADE)");
    }

    private static boolean isEmpty(Connection conn, String table) throws SQLException {
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM " + table)) {
            rs.next();
            return rs.getInt(1) == 0;
        }
    }

    /**
     * Ievieto sākuma datus tikai tad, ja attiecīgā tabula ir tukša: administratora kontu, divas zāles ar vietām,
     * trīs filmas un dažus nākotnes seansus.
     */
    private static void seedDefaultData(Connection conn) throws SQLException {
        if (isEmpty(conn, "users")) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users (first_name, last_name, username, email, password_hash, role) "
                    + "VALUES (?, ?, ?, ?, ?, 'admin')", Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, "Administrators");
                ps.setString(2, "Sistēmas");
                ps.setString(3, DEFAULT_ADMIN_USERNAME);
                ps.setString(4, "admin@kino.lv");
                ps.setString(5, PasswordUtil.hash(DEFAULT_ADMIN_PASSWORD));
                ps.executeUpdate();
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    keys.next();
                    try (PreparedStatement ps2 = conn.prepareStatement(
                            "INSERT INTO admins (user_id, rights) VALUES (?, ?)")) {
                        ps2.setInt(1, keys.getInt(1));
                        ps2.setString(2, "movies,screenings,users,reservations");
                        ps2.executeUpdate();
                    }
                }
            }
        }
        if (isEmpty(conn, "halls")) {
            addHallWithSeats(conn, "1. zāle", 5, 8);
            addHallWithSeats(conn, "2. zāle", 6, 10);
        }
        if (isEmpty(conn, "movies")) {
            addMovie(conn, "Zvaigžņu ceļojums", "Fantastika", 128, "Kosmosa piedzīvojumu filma par drosmīgu ekipāžu.");
            addMovie(conn, "Klusā nakts", "Drāma", 105, "Emocionāls stāsts par ģimeni ziemas vakarā.");
            addMovie(conn, "Smieklu vakars", "Komēdija", 96, "Viegla komēdija visai ģimenei.");
        }
        if (isEmpty(conn, "screenings")) {
            LocalDate tomorrow = LocalDate.now().plusDays(1);
            addScreening(conn, "Zvaigžņu ceļojums", "1. zāle", tomorrow, "18:00:00", "7.50");
            addScreening(conn, "Zvaigžņu ceļojums", "2. zāle", tomorrow.plusDays(1), "20:30:00", "6.50");
            addScreening(conn, "Klusā nakts", "1. zāle", tomorrow.plusDays(1), "19:00:00", "6.00");
            addScreening(conn, "Smieklu vakars", "2. zāle", tomorrow, "16:30:00", "5.50");
        }
    }

    private static void addHallWithSeats(Connection conn, String name, int rows, int seatsPerRow) throws SQLException {
        int hallId;
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO halls (name, seat_count) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setInt(2, rows * seatsPerRow);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                keys.next();
                hallId = keys.getInt(1);
            }
        }
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO seats (hall_id, seat_row, seat_number) VALUES (?, ?, ?)")) {
            for (int r = 1; r <= rows; r++) {
                for (int s = 1; s <= seatsPerRow; s++) {
                    ps.setInt(1, hallId);
                    ps.setInt(2, r);
                    ps.setInt(3, s);
                    ps.addBatch();
                }
            }
            ps.executeBatch();
        }
    }

    private static void addMovie(Connection conn, String title, String genre, int minutes, String description)
            throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO movies (title, genre, duration_min, description) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, title);
            ps.setString(2, genre);
            ps.setInt(3, minutes);
            ps.setString(4, description);
            ps.executeUpdate();
        }
    }

    private static void addScreening(Connection conn, String movieTitle, String hallName, LocalDate date,
            String time, String price) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO screenings (movie_id, hall_id, screening_date, screening_time, price) "
                + "VALUES ((SELECT id FROM movies WHERE title = ?), (SELECT id FROM halls WHERE name = ?), ?, ?, ?)")) {
            ps.setString(1, movieTitle);
            ps.setString(2, hallName);
            ps.setDate(3, java.sql.Date.valueOf(date));
            ps.setTime(4, java.sql.Time.valueOf(time));
            ps.setBigDecimal(5, new BigDecimal(price));
            ps.executeUpdate();
        }
    }
}
