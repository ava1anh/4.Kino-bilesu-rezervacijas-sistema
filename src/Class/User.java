/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Andrejs Ivaninoks
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String passwordHash;
    private String role;

    public User(){
    }  
    
    /**
     * Izveido jaunu objektu ar norādītajiem datiem (identifikators tiek piešķirts datu bāzē).
     *
     * @param firstName lietotāja vārds
     * @param lastName lietotāja uzvārds
     * @param username lietotājvārds (login)
     * @param email e-pasta adrese
     * @param role lietotāja loma (customer vai admin)
     */
    public User(String firstName, String lastName, String username, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    /**
     * Atgriež lietotāja identifikatoru.
     *
     * @return lietotāja identifikators
     */
    public int getId() {
        return id;
    }

    /**
     * Iestata lietotāja identifikatoru.
     *
     * @param id lietotāja identifikators
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atgriež lietotāja vārdu.
     *
     * @return lietotāja vārds
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Iestata lietotāja vārdu.
     *
     * @param firstName lietotāja vārds
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Atgriež lietotāja uzvārdu.
     *
     * @return lietotāja uzvārds
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Iestata lietotāja uzvārdu.
     *
     * @param lastName lietotāja uzvārds
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Atgriež lietotājvārdu.
     *
     * @return lietotājvārds (login)
     */
    public String getUsername() {
        return username;
    }

    /**
     * Iestata lietotājvārdu.
     *
     * @param username lietotājvārds (login)
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Atgriež e-pasta adresi.
     *
     * @return e-pasta adrese
     */
    public String getEmail() {
        return email;
    }

    /**
     * Iestata e-pasta adresi.
     *
     * @param email e-pasta adrese
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Atgriež paroles jaucējkodu.
     *
     * @return paroles SHA-256 jaucējkods
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Iestata paroles jaucējkodu.
     *
     * @param passwordHash paroles SHA-256 jaucējkods
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Atgriež lietotāja lomu.
     *
     * @return lietotāja loma (customer vai admin)
     */
    public String getRole() {
        return role;
    }

    /**
     * Iestata lietotāja lomu.
     *
     * @param role lietotāja loma (customer vai admin)
     */
    public void setRole(String role) {
        this.role = role;
    }

    /** Lomas nosaukums parastam klientam. */
    public static final String ROLE_CUSTOMER = "customer";

    /** Lomas nosaukums administratoram. */
    public static final String ROLE_ADMIN = "admin";

    /**
     * Pārbauda, vai lietotājs ir administrators.
     *
     * @return true, ja lietotāja loma ir admin
     */
    public boolean isAdmin() {
        return ROLE_ADMIN.equals(role);
    }

    /**
     * Atgriež lietotāja vārdu, uzvārdu un lietotājvārdu tekstā.
     *
     * @return teksta attēlojums
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + username + ")";
    }

}
