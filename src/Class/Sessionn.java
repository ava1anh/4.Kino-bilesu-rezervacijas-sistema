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
    private Date date;
    private Time time;
    private BigDecimal price;
    
    public Sessionn(){
    }
    
    public Sessionn(int movieId, int hallId, Date date, Time time, BigDecimal price) {
       this.movieId = movieId;
       this.hallId = hallId;
       this.date = date;
       this.time = time;
       this.price = price;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString() {
        return date + " " + time + " (" + price + " EUR)";
    }
}
