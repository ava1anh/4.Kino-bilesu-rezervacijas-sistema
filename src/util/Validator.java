/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
/**
 *
 * @author andre
 */
public final class Validator {

    private static final Pattern USERNAME = Pattern.compile("^[A-Za-z0-9_]{3,30}$");
    private static final Pattern EMAIL = Pattern.compile("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$");
    private static final Pattern NAME = Pattern.compile("^\\p{L}[\\p{L} '\\-]{0,49}$");
    private static final BigDecimal MAX_PRICE = new BigDecimal("9999.99");

    /** Minimālais paroles garums. */
    public static final int MIN_PASSWORD_LENGTH = 5;

    private Validator() {
    }

    /**
     * Pārbauda, vai teksts ir null, tukšs vai satur tikai atstarpes.
     *
     * @param text pārbaudāmais teksts
     * @return true, ja teksts ir tukšs
     */
    public static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    /**
     * Pārbauda lietotājvārdu: 3-30 rakstzīmes, tikai burti (a-z), cipari un pasvītrojums.
     *
     * @param username pārbaudāmais lietotājvārds
     * @return true, ja lietotājvārds ir derīgs
     */
    public static boolean isValidUsername(String username) {
        return username != null && USERNAME.matcher(username).matches();
    }

    /**
     * Pārbauda e-pasta adreses formātu (garums līdz 100 rakstzīmēm).
     *
     * @param email pārbaudāmā e-pasta adrese
     * @return true, ja formāts ir derīgs
     */
    public static boolean isValidEmail(String email) {
        return email != null && email.length() <= 100 && EMAIL.matcher(email).matches();
    }

    /**
     * Pārbauda vārdu vai uzvārdu: sākas ar burtu, drīkst saturēt burtus (arī latviešu), atstarpi, apostrofu un defisi.
     *
     * @param name pārbaudāmais vārds vai uzvārds
     * @return true, ja vārds ir derīgs
     */
    public static boolean isValidName(String name) {
        return name != null && NAME.matcher(name.trim()).matches();
    }

    /**
     * Pārbauda paroles garumu (vismaz {@value #MIN_PASSWORD_LENGTH} rakstzīmes, ne vairāk kā 100).
     *
     * @param password pārbaudāmā parole
     * @return true, ja parole ir pietiekami gara
     */
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= MIN_PASSWORD_LENGTH && password.length() <= 100;
    }

    /**
     * Pārveido tekstu par pozitīvu veselu skaitli.
     *
     * @param text ievadītais teksts
     * @return skaitlis vai null, ja teksts nav pozitīvs vesels skaitlis
     */
    public static Integer parsePositiveInt(String text) {
        if (isBlank(text)) {
            return null;
        }
        try {
            int value = Integer.parseInt(text.trim());
            return value > 0 ? value : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Pārveido tekstu formātā gggg-mm-dd par datumu.
     *
     * @param text ievadītais teksts
     * @return datums vai null, ja formāts nav pareizs
     */
    public static LocalDate parseDate(String text) {
        if (isBlank(text)) {
            return null;
        }
        try {
            return LocalDate.parse(text.trim());
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Pārveido tekstu formātā hh:mm par laiku.
     *
     * @param text ievadītais teksts
     * @return laiks vai null, ja formāts nav pareizs
     */
    public static LocalTime parseTime(String text) {
        if (isBlank(text)) {
            return null;
        }
        try {
            return LocalTime.parse(text.trim());
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Pārveido tekstu par cenu (atļauts gan punkts, gan komats). Cena jāpārbauda pret tabulas ierobežojumu DECIMAL(6,2).
     *
     * @param text ievadītais teksts
     * @return cena ar 2 zīmēm aiz komata vai null, ja cena nav pozitīva vai ir pārāk liela
     */
    public static BigDecimal parsePrice(String text) {
        if (isBlank(text)) {
            return null;
        }
        try {
            BigDecimal price = new BigDecimal(text.trim().replace(',', '.'));
            if (price.signum() <= 0 || price.compareTo(MAX_PRICE) > 0) {
                return null;
            }
            return price.setScale(2, java.math.RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
