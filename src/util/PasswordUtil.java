package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Palīgklase paroles SHA-256 jaucējkoda iegūšanai.
 * Datu bāzē tiek glabāts tikai jaucējkods (64 heksadecimālas rakstzīmes), nevis pati parole.
 */
public final class PasswordUtil {

    private PasswordUtil() {
    }

    /**
     * Aprēķina paroles SHA-256 jaucējkodu.
     *
     * @param password parole atklātā tekstā
     * @return jaucējkods kā 64 rakstzīmju heksadecimāla virkne
     * @throws IllegalArgumentException ja parole ir null
     */
    public static String hash(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Parole nedrīkst būt null.");
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
