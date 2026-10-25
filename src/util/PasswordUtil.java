/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author andre
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
