/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Andrejs Ivaninoks
 */
public class Admin {

    private int id;
    private int userId;
    private String tiesibas;
    
    public Admin(){
    }
    
    public Admin(int userId, String tiesibas){
        this.userId = userId;
        this.tiesibas = tiesibas;
    }
   
    public int getId(){
        return id;
    }
    
    public void setId(int aInt){
        this.id = id;
    }
    
    public int getUserId(){
        return userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    public String getTiesibas(){
        return tiesibas;
    }
    
    public void setTiesibas(String tiesibas){
        this.tiesibas = tiesibas;
    }
}