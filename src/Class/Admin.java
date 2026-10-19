/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Andrejs Ivaninoks
 */
public class Admin {

    private int id;
    private int userId;
    private String rights;

    public Admin(){
    }
    
    /**
     * Izveido jaunu objektu ar norādītajiem datiem (identifikators tiek piešķirts datu bāzē).
     *
     * @param userId saistītā lietotāja identifikators
     * @param rights administratora tiesības
     */
    public Admin(int userId, String rights) {
        this.userId = userId;
        this.rights = rights;
    }

    /**
     * Atgriež administratora ieraksta identifikatoru.
     *
     * @return administratora ieraksta identifikators
     */
    public int getId() {
        return id;
    }

    /**
     * Iestata administratora ieraksta identifikatoru.
     *
     * @param id administratora ieraksta identifikators
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atgriež saistītā lietotāja identifikatoru.
     *
     * @return saistītā lietotāja identifikators
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Iestata saistītā lietotāja identifikatoru.
     *
     * @param userId saistītā lietotāja identifikators
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Atgriež administratora tiesības.
     *
     * @return administratora tiesības
     */
    public String getRights() {
        return rights;
    }

    /**
     * Iestata administratora tiesības.
     *
     * @param rights administratora tiesības
     */
    public void setRights(String rights) {
        this.rights = rights;
    }

}
