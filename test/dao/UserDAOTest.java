package dao;

import static org.junit.Assert.*;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.TestDb;

/**
 * UserDAO testi: reģistrēšanās un ielogošanās ar pareiziem un nepareiziem datiem
 * (četri pamata scenāriji) un papildu pārbaudes.
 *
 * <p>Testu secībai nav nozīmes; pirms un pēc katra testa tiek dzēsts testa lietotājs.</p>
 */
public class UserDAOTest {

    private static final String TEST_USER = "testUser";

    private UserDAO dao;

    @BeforeClass
    public static void setUpClass() {
        TestDb.setUp();
    }

    @AfterClass
    public static void tearDownClass() {
        boolean result = new UserDAO().deleteUser(TEST_USER);
        if (result) {
            System.out.println("Testa lietotājs \"testUser\" ir izdzēsts.");
        }
    }

    @Before
    public void setUp() {
        dao = new UserDAO();
        dao.deleteUser(TEST_USER);
    }

    @After
    public void tearDown() {
        dao.deleteUser(TEST_USER);
    }

    private User newUser() {
        return new User("Test", "User", TEST_USER, "test.user@example.com", User.ROLE_CUSTOMER);
    }

    /** Jauna lietotāja reģistrācija. */
    @Test
    public void testRegister() {
        int id = dao.register(newUser(), "12345");
        assertTrue("Lietotāju \"testUser\" reģistrēt neizdevās!", id > 0);
    }

    /** Mēģinājums reģistrēt jau esošu lietotājvārdu. */
    @Test
    public void testRegisterExistingUser() {
        dao.register(newUser(), "12345");
        int result = dao.register(newUser(), "54321");
        assertEquals("Izdevās reģistrēt lietotāju ar jau esošu lietotājvārdu!", -1, result);
    }

    /** Veiksmīga ielogošanās. */
    @Test
    public void testLogin() {
        dao.register(newUser(), "12345");
        User user = dao.login(TEST_USER, "12345");
        assertNotNull("Lietotājam \"testUser\" neizdevās ielogoties!", user);
        assertEquals(TEST_USER, user.getUsername());
        assertEquals(User.ROLE_CUSTOMER, user.getRole());
    }

    /** Ielogošanās ar nepareizu paroli. */
    @Test
    public void testLoginWrongPassword() {
        dao.register(newUser(), "12345");
        assertNull("Lietotājs ielogojās ar nepareizo paroli!", dao.login(TEST_USER, "wrongPassword"));
    }

    /** Parole datubāzē nedrīkst tikt glabāta atklātā tekstā. */
    @Test
    public void testPasswordIsStoredAsHash() throws Exception {
        dao.register(newUser(), "12345");
        try (java.sql.Connection c = db.DatabaseManager.getConnection();
             java.sql.PreparedStatement ps = c.prepareStatement("SELECT password_hash FROM users WHERE username = ?")) {
            ps.setString(1, TEST_USER);
            java.sql.ResultSet rs = ps.executeQuery();
            assertTrue(rs.next());
            assertEquals(util.PasswordUtil.hash("12345"), rs.getString(1));
        }
    }

    @Test
    public void testUpdateAndFind() {
        int id = dao.register(newUser(), "12345");
        User u = dao.findById(id);
        u.setFirstName("Jaunais");
        assertTrue(dao.update(u));
        assertEquals("Jaunais", dao.findByUsername(TEST_USER).getFirstName());
    }

    @Test
    public void testDeleteUser() {
        dao.register(newUser(), "12345");
        assertTrue(dao.deleteUser(TEST_USER));
        assertNull(dao.findByUsername(TEST_USER));
        assertFalse("otrreiz dzēst nav ko", dao.deleteUser(TEST_USER));
    }

    /** E-pastam jābūt unikālam (datu integritāte). */
    @Test
    public void testDuplicateEmailRejected() {
        dao.register(newUser(), "12345");
        User other = new User("Cits", "Lietotajs", "testUser2", "test.user@example.com", User.ROLE_CUSTOMER);
        try {
            assertEquals(-1, dao.register(other, "12345"));
        } finally {
            dao.deleteUser("testUser2");
        }
    }
}
