package model;

/**
 * Attēlo kino zāli. Atbilst tabulai HALLS.
 */
public class Hall {

    private int id;
    private String name;
    private int seatCount;

    /**
     * Izveido tukšu objektu (izmanto DAO klases, lai aizpildītu datus no datu bāzes).
     */
    public Hall() {
    }

    /**
     * Izveido jaunu objektu ar norādītajiem datiem (identifikators tiek piešķirts datu bāzē).
     *
     * @param name zāles nosaukums
     * @param seatCount vietu skaits zālē
     */
    public Hall(String name, int seatCount) {
        this.name = name;
        this.seatCount = seatCount;
    }

    /**
     * Atgriež zāles identifikatoru.
     *
     * @return zāles identifikators
     */
    public int getId() {
        return id;
    }

    /**
     * Iestata zāles identifikatoru.
     *
     * @param id zāles identifikators
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atgriež zāles nosaukumu.
     *
     * @return zāles nosaukums
     */
    public String getName() {
        return name;
    }

    /**
     * Iestata zāles nosaukumu.
     *
     * @param name zāles nosaukums
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Atgriež vietu skaitu zālē.
     *
     * @return vietu skaits zālē
     */
    public int getSeatCount() {
        return seatCount;
    }

    /**
     * Iestata vietu skaitu zālē.
     *
     * @param seatCount vietu skaits zālē
     */
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    /**
     * Atgriež zāles nosaukumu un vietu skaitu tekstā.
     *
     * @return teksta attēlojums
     */
    @Override
    public String toString() {
        return name + " (" + seatCount + " vietas)";
    }

}
