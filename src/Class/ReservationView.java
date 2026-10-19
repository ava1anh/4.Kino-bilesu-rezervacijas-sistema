/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author andre
 */
public class ReservationView {

    private int id;
    private String username;
    private String movieTitle;
    private String hallName;
    private LocalDate date;
    private LocalTime time;
    private int seatRow;
    private int seatNumber;
    private String status;
    private BigDecimal deposit;

    public ReservationView() {
    }

    /**
     * Atgriež rezervācijas identifikatoru.
     *
     * @return rezervācijas identifikators
     */
    public int getId() {
        return id;
    }

    /**
     * Iestata rezervācijas identifikatoru.
     *
     * @param id rezervācijas identifikators
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atgriež lietotājvārdu.
     *
     * @return lietotājvārds
     */
    public String getUsername() {
        return username;
    }

    /**
     * Iestata lietotājvārdu.
     *
     * @param username lietotājvārds
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Atgriež filmas nosaukumu.
     *
     * @return filmas nosaukums
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Iestata filmas nosaukumu.
     *
     * @param movieTitle filmas nosaukums
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * Atgriež zāles nosaukumu.
     *
     * @return zāles nosaukums
     */
    public String getHallName() {
        return hallName;
    }

    /**
     * Iestata zāles nosaukumu.
     *
     * @param hallName zāles nosaukums
     */
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    /**
     * Atgriež seansa datumu.
     *
     * @return seansa datums
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Iestata seansa datumu.
     *
     * @param date seansa datums
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Atgriež seansa sākuma laiku.
     *
     * @return seansa sākuma laiks
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Iestata seansa sākuma laiku.
     *
     * @param time seansa sākuma laiks
     */
    public void setTime(LocalTime time) {
        this.time = time;
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
     * Atgriež vietas numuru.
     *
     * @return vietas numurs
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * Iestata vietas numuru.
     *
     * @param seatNumber vietas numurs
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Atgriež rezervācijas statusu.
     *
     * @return rezervācijas statuss
     */
    public String getStatus() {
        return status;
    }

    /**
     * Iestata rezervācijas statusu.
     *
     * @param status rezervācijas statuss
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Atgriež iemaksas summu.
     *
     * @return iemaksas summa (EUR)
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * Iestata iemaksas summu.
     *
     * @param deposit iemaksas summa (EUR)
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

}

