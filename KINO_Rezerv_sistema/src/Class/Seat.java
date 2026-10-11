/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Andrejs Ivaninnoks
 */
public class Seat {
    
    private int id;
    private int hallId;
    private int rinda;
    private int vietaNr;
    
public Seat(){
}

    public Seat(int hallId, int rinda, int vietaNr){
        this.hallId = hallId;
        this.rinda = rinda;
        this.vietaNr = vietaNr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public int getRinda() {
        return rinda;
    }

    public void setRinda(int rinda) {
        this.rinda = rinda;
    }

    public int getVietaNr() {
        return vietaNr;
    }

    public void setVietaNr(int vietaNr) {
        this.vietaNr = vietaNr;
    }

    public String toString() {
        return "Rinda " + rinda + ", vieta " + vietaNr;
    }
}
