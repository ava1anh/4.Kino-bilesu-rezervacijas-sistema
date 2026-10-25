package service;

import static org.junit.Assert.*;
import dao.UserDAO;
import model.User;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import util.TestDb;

/**
 * UserService testi: reģistrācijas datu validācija un pieslēgšanās.
 */
public class UserServiceTest {

    private final UserService service = new UserService();

    @BeforeClass
    public static void setUpClass() {
        TestDb.setUp();
    }

    @After
    public void tearDown() {
        new UserDAO().deleteUser("service_user");
    }

    private void expectError(String expectedPart, String fn, String ln, String un, String em, String pw, String pw2) {
        try {
            service.register(fn, ln, un, em, pw, pw2);
            fail("Sagaidīja BusinessException: " + expectedPart);
        } catch (BusinessException e) {
            assertTrue("Ziņojums: " + e.getMessage(), e.getMessage().contains(expectedPart));
        }
    }

    @Test
    public void testRegisterRejectsEmptyFields() {
        expectError("Aizpildiet", "", "Ozols", "service_user", "a@b.lv", "12345", "12345");
    }

    @Test
    public void testRegisterRejectsBadEmail() {
        expectError("e-pasta", "Jānis", "Ozols", "service_user", "nav-epasts", "12345", "12345");
    }

    @Test
    public void testRegisterRejectsShortPassword() {
        expectError("Parolei", "Jānis", "Ozols", "service_user", "a@b.lv", "123", "123");
    }

    @Test
    public void testRegisterRejectsPasswordMismatch() {
        expectError("nesakrīt", "Jānis", "Ozols", "service_user", "a@b.lv", "12345", "54321");
    }

    @Test
    public void testRegisterAndLogin() throws BusinessException {
        int id = service.register("Jānis", "Ozols", "service_user", "service.user@example.com", "12345", "12345");
        assertTrue(id > 0);
        User u = service.login("service_user", "12345");
        assertEquals(id, u.getId());
        assertEquals(User.ROLE_CUSTOMER, u.getRole());
    }

    @Test
    public void testRegisterDuplicateUsername() throws BusinessException {
        service.register("Jānis", "Ozols", "service_user", "service.user@example.com", "12345", "12345");
        expectError("jau eksistē", "Anna", "Liepa", "service_user", "cits@example.com", "12345", "12345");
    }

    @Test
    public void testLoginWrongPasswordAndEmptyFields() throws BusinessException {
        service.register("Jānis", "Ozols", "service_user", "service.user@example.com", "12345", "12345");
        try {
            service.login("service_user", "nepareiza");
            fail();
        } catch (BusinessException e) {
            assertEquals("Nepareizs lietotājvārds vai parole.", e.getMessage());
        }
        try {
            service.login("", "");
            fail();
        } catch (BusinessException e) {
            assertTrue(e.getMessage().contains("Ievadiet"));
        }
    }
}
