/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author Adrejs Ivaninoks
 */
public class Screening {

    private int id;
    private int movieId;
    private int hallId;
    private LocalDate date;
    private LocalTime time;
    private BigDecimal price;


    public Screening() {
    }

    /**
     * Izveido jaunu objektu ar norādītajiem datiem (identifikators tiek piešķirts datu bāzē).
     *
     * @param movieId filmas identifikators
     * @param hallId zāles identifikators
     * @param date seansa datums
     * @param time seansa sākuma laiks
     * @param price biļetes cena (EUR)
     */
    public Screening(int movieId, int hallId, LocalDate date, LocalTime time, BigDecimal price) {
        this.movieId = movieId;
        this.hallId = hallId;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    /**
     * Atgriež seansa identifikatoru.
     *
     * @return seansa identifikators
     */
    public int getId() {
        return id;
    }

    /**
     * Iestata seansa identifikatoru.
     *
     * @param id seansa identifikators
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atgriež filmas identifikatoru.
     *
     * @return filmas identifikators
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Iestata filmas identifikatoru.
     *
     * @param movieId filmas identifikators
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
     * Atgriež biļetes cenu.
     *
     * @return biļetes cena (EUR)
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Iestata biļetes cenu.
     *
     * @param price biļetes cena (EUR)
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Atgriež seansa sākuma datumu un laiku kopā.
     *
     * @return seansa sākums vai null, ja datums vai laiks nav norādīts
     */
    public LocalDateTime getStartDateTime() {
        return (date == null || time == null) ? null : LocalDateTime.of(date, time);
    }

    /**
     * Atgriež seansa datumu, laiku un cenu tekstā.
     *
     * @return teksta attēlojums
     */
    @Override
    public String toString() {
        return date + " " + time + " (" + price + " EUR)";
    }

}

