/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Andrejs Ivaninoks
 */
public class Hall {
    
    private int id;
    private String nosaukums;
    private int vietuSkaits;
    
    public Hall(String nosaukums, int vietuSkaits){
        this.nosaukums = nosaukums;
        this.vietuSkaits= vietuSkaits;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNosaukums(){
        return nosaukums;
    }
    
    public void setNosakumus(String nosaukums){
        this.nosaukums = nosaukums;
    }
    
    public int getVietuSkaits(){
        return vietuSkaits;
    }
    
    public void setVietuSkaits(int vietuSkaits){
        this.vietuSkaits = vietuSkaits;
    }
    
    public String toString(){
        return nosaukums + "(" + vietuSkaits + " vietas)";
    }
}
