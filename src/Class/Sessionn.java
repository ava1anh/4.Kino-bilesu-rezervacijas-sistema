/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author Andrejs Ivaninoks
 */
public class Sessionn {
   
    private int id;
    private int movieId;
    private int hallId;
    private Date datums;
    private Time laiks;
    private BigDecimal cena;
    
    public Sessionn(){
    }
    
    public Sessionn(int movieId, int hallId, Date datums, Time laiks, BigDecimal cena) {
       this.movieId = movieId;
       this.hallId = hallId;
       this.datums = datums;
       this.laiks = laiks;
       this.cena = cena;
    }

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public Date getDatums() {
        return datums;
    }

    public void setDatums(Date datums) {
        this.datums = datums;
    }

    public Time getLaiks() {
        return laiks;
    }

    public void setLaiks(Time laiks) {
        this.laiks = laiks;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String toString() {
        return datums + " " + laiks + " (" + cena + " EUR)";
    }
}
