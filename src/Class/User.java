/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Andrejs Ivaninoks
 */
public class User {

    private int id;
    private String vards;
    private String uzvards;
    private String lietotajvards;
    private String parolehash;
    private String epasts;
    private String loma;

    public User(){
    }  
    
    public User(String vards, String uzvards, String lietotajvards, String parolehash, String epasts, String loma){
    
        this.vards = vards;
        this.uzvards = uzvards;
        this.lietotajvards = lietotajvards;
        this.parolehash = parolehash;
        this.epasts = epasts;
        this.loma = loma;           
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getVards(){
        return vards;
    }
    
    public void setVards(String vards){
        this.vards = vards;
    }
    
    public String getUzvards(){
        return uzvards;
    }
    
    public void setUzvards(String uzvards){
        this.uzvards = uzvards;
    }
    
    public String getLietotajvards(){
        return lietotajvards;
    }
    
    public void setLietotajvards(String lietotajvards){
        this.lietotajvards = lietotajvards;
    }
    
    public String getParolehash(){
        return parolehash;
    }
    
    public void setParolehash(String parolehash){
        this.parolehash = parolehash;
    }
    
    public String getEpasts(){
        return epasts;
    }
    
    public void setEpasts(String epasts){
        this.epasts = epasts;
    }
    
    public String getLoma(){
        return loma;
    }
    
    public void setLoma(String loma){
        this.loma = loma;
    }
    
    public String toString(){
        return vards +" "+ uzvards + "(" + lietotajvards + ")";
    }
}