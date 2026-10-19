/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Andrejs Ivaninoks
 */
public class Movie {

    private int id;
    private String title;
    private String genre;
    private int durationMin;
    private String description;
    
    public Movie() {
    }

    /**
     * Izveido jaunu objektu ar norādītajiem datiem (identifikators tiek piešķirts datu bāzē).
     *
     * @param title filmas nosaukums
     * @param genre filmas žanrs
     * @param durationMin filmas ilgums minūtēs
     * @param description filmas apraksts
     */
    public Movie(String title, String genre, int durationMin, String description) {
        this.title = title;
        this.genre = genre;
        this.durationMin = durationMin;
        this.description = description;
    }

    /**
     * Atgriež filmas identifikatoru.
     *
     * @return filmas identifikators
     */
    public int getId() {
        return id;
    }

    /**
     * Iestata filmas identifikatoru.
     *
     * @param id filmas identifikators
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atgriež filmas nosaukumu.
     *
     * @return filmas nosaukums
     */
    public String getTitle() {
        return title;
    }

    /**
     * Iestata filmas nosaukumu.
     *
     * @param title filmas nosaukums
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Atgriež filmas žanru.
     *
     * @return filmas žanrs
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Iestata filmas žanru.
     *
     * @param genre filmas žanrs
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Atgriež filmas ilgumu minūtēs.
     *
     * @return filmas ilgums minūtēs
     */
    public int getDurationMin() {
        return durationMin;
    }

    /**
     * Iestata filmas ilgumu minūtēs.
     *
     * @param durationMin filmas ilgums minūtēs
     */
    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    /**
     * Atgriež filmas aprakstu.
     *
     * @return filmas apraksts
     */
    public String getDescription() {
        return description;
    }

    /**
     * Iestata filmas aprakstu.
     *
     * @param description filmas apraksts
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Atgriež filmas nosaukumu, žanru un ilgumu tekstā.
     *
     * @return teksta attēlojums
     */
    @Override
    public String toString() {
        return title + " (" + genre + ", " + durationMin + " min)";
    }

}
