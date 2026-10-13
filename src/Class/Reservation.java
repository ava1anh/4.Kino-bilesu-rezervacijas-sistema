/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.math.BigDecimal;
import java.security.Timestamp;

/**
 *
 * @author Andrejs Ivaninnoks
 */
public class Reservation {
    
    private int id;
    private int userId;
    private int sessionId;
    private int seatId;
    private String statuss;
    private BigDecimal iemaksa;
    private Timestamp izveidesLaiks;

    public Reservation() {
    }

    public Reservation(int userId, int sessionId, int seatId, String statuss, BigDecimal iemaksa) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.seatId = seatId;
        this.statuss = statuss;
        this.iemaksa = iemaksa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public BigDecimal getIemaksa() {
        return iemaksa;
    }

    public void setIemaksa(BigDecimal iemaksa) {
        this.iemaksa = iemaksa;
    }

    public Timestamp getIzveidesLaiks() {
        return izveidesLaiks;
    }

    public void setIzveidesLaiks(Timestamp izveidesLaiks) {
        this.izveidesLaiks = izveidesLaiks;
    }
    
}
