/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.User;
/**
 *
 * @author andre
 */
public class Session {

    /** Pieslēgtā lietotāja identifikators; -1, ja neviens nav pieslēdzies. */
    public static int userId = -1;

    /** Pieslēgtā lietotāja lietotājvārds. */
    public static String username = "";

    /** Pieslēgtā lietotāja loma (customer vai admin). */
    public static String role = "";

    private Session() {
    }

    /**
     * Saglabā sesijā veiksmīgi pieslēgušos lietotāju.
     *
     * @param user lietotājs, kurš pieslēdzies sistēmai
     */
    public static void login(User user) {
        userId = user.getId();
        username = user.getUsername();
        role = user.getRole();
    }

    /**
     * Notīra sesijas datus (lietotāja izlogošanās).
     */
    public static void logout() {
        userId = -1;
        username = "";
        role = "";
    }

    /**
     * Pārbauda, vai kāds lietotājs ir pieslēdzies.
     *
     * @return true, ja sesijā ir pieslēdzies lietotājs
     */
    public static boolean isLoggedIn() {
        return userId != -1;
    }

    /**
     * Pārbauda, vai pieslēgtajam lietotājam ir administratora loma.
     *
     * @return true, ja lietotājs ir administrators
     */
    public static boolean isAdmin() {
        return isLoggedIn() && User.ROLE_ADMIN.equals(role);
    }
}
