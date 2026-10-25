package util;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Test;

/**
 * Datu validācijas pārbaude: klase Validator.
 */
public class ValidatorTest {

    @Test
    public void testIsBlank() {
        assertTrue(Validator.isBlank(null));
        assertTrue(Validator.isBlank("   "));
        assertFalse(Validator.isBlank(" a "));
    }

    @Test
    public void testUsername() {
        assertTrue(Validator.isValidUsername("janis_01"));
        assertFalse("pārāk īss", Validator.isValidUsername("ab"));
        assertFalse("aizliegta atstarpe", Validator.isValidUsername("jan is"));
        assertFalse("latviešu burti nav atļauti", Validator.isValidUsername("jānis"));
        assertFalse("pārāk garš", Validator.isValidUsername("a123456789012345678901234567890"));
    }

    @Test
    public void testEmail() {
        assertTrue(Validator.isValidEmail("liga.kalnina@example.com"));
        assertFalse(Validator.isValidEmail("liga@"));
        assertFalse(Validator.isValidEmail("liga.example.com"));
        assertFalse(Validator.isValidEmail(null));
    }

    @Test
    public void testName() {
        assertTrue(Validator.isValidName("Jānis"));
        assertTrue(Validator.isValidName("Anna-Marija"));
        assertFalse(Validator.isValidName("J4nis"));
        assertFalse(Validator.isValidName(""));
    }

    @Test
    public void testPasswordLength() {
        assertTrue(Validator.isValidPassword("12345"));
        assertFalse(Validator.isValidPassword("1234"));
        assertFalse(Validator.isValidPassword(null));
    }

    @Test
    public void testParsePositiveInt() {
        assertEquals(Integer.valueOf(120), Validator.parsePositiveInt(" 120 "));
        assertNull(Validator.parsePositiveInt("0"));
        assertNull(Validator.parsePositiveInt("-5"));
        assertNull(Validator.parsePositiveInt("abc"));
        assertNull(Validator.parsePositiveInt(""));
    }

    @Test
    public void testParseDateAndTime() {
        assertEquals(LocalDate.of(2030, 5, 17), Validator.parseDate("2030-05-17"));
        assertNull(Validator.parseDate("17.05.2030"));
        assertNull(Validator.parseDate("2030-13-40"));
        assertEquals(LocalTime.of(18, 30), Validator.parseTime("18:30"));
        assertNull(Validator.parseTime("25:00"));
        assertNull(Validator.parseTime("abc"));
    }

    @Test
    public void testParsePrice() {
        assertEquals(new BigDecimal("7.50"), Validator.parsePrice("7,5"));
        assertEquals(new BigDecimal("6.00"), Validator.parsePrice("6"));
        assertNull("nulle nav atļauta", Validator.parsePrice("0"));
        assertNull("negatīva cena", Validator.parsePrice("-1"));
        assertNull("pārāk liela cena", Validator.parsePrice("100000"));
        assertNull(Validator.parsePrice("abc"));
    }
}
