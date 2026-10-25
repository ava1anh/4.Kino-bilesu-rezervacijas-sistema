/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Andrejs Ivaninnoks
 */
public class Reservation {
    
    private int id;
    private int userId;
    private int screeningId;
    private int seatId;
    private String status;
    private BigDecimal deposit;
    private LocalDateTime createdAt;

    public Reservation() {
    }

    /**
     * Izveido jaunu objektu ar norādītajiem datiem (identifikators tiek piešķirts datu bāzē).
     *
     * @param userId lietotāja identifikators
     * @param screeningId seansa identifikators
     * @param seatId vietas identifikators
     * @param status rezervācijas statuss (ACTIVE vai CANCELED)
     * @param deposit iemaksas summa (EUR)
     */
    public Reservation(int userId, int screeningId, int seatId, String status, BigDecimal deposit) {
        this.userId = userId;
        this.screeningId = screeningId;
        this.seatId = seatId;
        this.status = status;
        this.deposit = deposit;
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
     * Atgriež lietotāja identifikatoru.
     *
     * @return lietotāja identifikators
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Iestata lietotāja identifikatoru.
     *
     * @param userId lietotāja identifikators
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Atgriež seansa identifikatoru.
     *
     * @return seansa identifikators
     */
    public int getScreeningId() {
        return screeningId;
    }

    /**
     * Iestata seansa identifikatoru.
     *
     * @param screeningId seansa identifikators
     */
    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    /**
     * Atgriež vietas identifikatoru.
     *
     * @return vietas identifikators
     */
    public int getSeatId() {
        return seatId;
    }

    /**
     * Iestata vietas identifikatoru.
     *
     * @param seatId vietas identifikators
     */
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    /**
     * Atgriež rezervācijas statusu.
     *
     * @return rezervācijas statuss (ACTIVE vai CANCELED)
     */
    public String getStatus() {
        return status;
    }

    /**
     * Iestata rezervācijas statusu.
     *
     * @param status rezervācijas statuss (ACTIVE vai CANCELED)
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

    /**
     * Atgriež rezervācijas izveides laiku.
     *
     * @return rezervācijas izveides laiks
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Iestata rezervācijas izveides laiku.
     *
     * @param createdAt rezervācijas izveides laiks
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /** Statuss aktīvai rezervācijai. */
    public static final String STATUS_ACTIVE = "ACTIVE";

    /** Statuss atceltai rezervācijai. */
    public static final String STATUS_CANCELED = "CANCELED";

    /**
     * Pārbauda, vai rezervācija ir aktīva.
     *
     * @return true, ja statuss ir ACTIVE
     */
    public boolean isActive() {
        return STATUS_ACTIVE.equals(status);
    }

}

