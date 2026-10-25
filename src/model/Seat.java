package model;

/**
 * Attēlo konkrētu sēdvietu kādā no zālēm. Atbilst tabulai SEATS.
 */
public class Seat {

    private int id;
    private int hallId;
    private int seatRow;
    private int seatNumber;

    /**
     * Izveido tukšu objektu (izmanto DAO klases, lai aizpildītu datus no datu bāzes).
     */
    public Seat() {
    }

    /**
     * Izveido jaunu objektu ar norādītajiem datiem (identifikators tiek piešķirts datu bāzē).
     *
     * @param hallId zāles identifikators
     * @param seatRow rindas numurs
     * @param seatNumber vietas numurs rindā
     */
    public Seat(int hallId, int seatRow, int seatNumber) {
        this.hallId = hallId;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    /**
     * Atgriež vietas identifikatoru.
     *
     * @return vietas identifikators
     */
    public int getId() {
        return id;
    }

    /**
     * Iestata vietas identifikatoru.
     *
     * @param id vietas identifikators
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atgriež zāles identifikatoru.
     *
     * @return zāles identifikators
     */
    public int getHallId() {
        return hallId;
    }

    /**
     * Iestata zāles identifikatoru.
     *
     * @param hallId zāles identifikators
     */
    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    /**
     * Atgriež rindas numuru.
     *
     * @return rindas numurs
     */
    public int getSeatRow() {
        return seatRow;
    }

    /**
     * Iestata rindas numuru.
     *
     * @param seatRow rindas numurs
     */
    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    /**
     * Atgriež vietas numuru rindā.
     *
     * @return vietas numurs rindā
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * Iestata vietas numuru rindā.
     *
     * @param seatNumber vietas numurs rindā
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Atgriež rindas un vietas numuru tekstā.
     *
     * @return teksta attēlojums
     */
    @Override
    public String toString() {
        return "Rinda " + seatRow + ", vieta " + seatNumber;
    }

}
