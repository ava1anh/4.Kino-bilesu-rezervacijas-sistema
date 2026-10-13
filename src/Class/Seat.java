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
    private int RowNumber;
    private int SeatNumber;
    
public Seat(){
}

    public Seat(int hallId, int RowNumber, int SeatNumber){
        this.hallId = hallId;
        this.RowNumber = RowNumber;
        this.SeatNumber= SeatNumber;
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

    public int getRowNumber() {
        return RowNumber;
    }

    public void setRowNumber(int RowNumber) {
        this.RowNumber = RowNumber;
    }

    public int getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(int SeatNumber) {
        this.SeatNumber = SeatNumber;
    }

    public String toString() {
        return "Rinda " + RowNumber + ", vieta " + SeatNumber;
    }

    public boolean isAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setAvailable(boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
