package util;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Pārbauda paroles jaucējkoda funkciju PasswordUtil.
 */
public class PasswordUtilTest {

    /** SHA-256("abc") ir zināma standarta kontrolvērtība. */
    @Test
    public void testHashKnownValue() {
        assertEquals("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad",
                PasswordUtil.hash("abc"));
    }

    @Test
    public void testHashHas64HexCharacters() {
        String h = PasswordUtil.hash("12345");
        assertEquals(64, h.length());
        assertTrue(h.matches("[0-9a-f]{64}"));
    }

    @Test
    public void testSameInputSameHashDifferentInputDifferentHash() {
        assertEquals(PasswordUtil.hash("parole"), PasswordUtil.hash("parole"));
        assertNotEquals(PasswordUtil.hash("parole"), PasswordUtil.hash("Parole"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHashNullThrows() {
        PasswordUtil.hash(null);
    }
}
