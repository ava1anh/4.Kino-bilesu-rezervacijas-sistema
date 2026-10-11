/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Andrejs Ivaninoks
 */
public class Movie {

    private int id;
    private String nosaukums;
    private String zanrs;
    private int ilgumsMin;
    private String apraksts;
    
    public Movie(){ 
    }
    
    public Movie(String nosaukums, String zanrs, int ilgumsMin, String apraksts){
        this.nosaukums = nosaukums;
        this.zanrs = zanrs;
        this.ilgumsMin = ilgumsMin;
        this.apraksts = apraksts;
    }
    
    public int getId(int id){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNosaukums(){
        return nosaukums;
    }
    
    public void setNosaukums(String nosaukums){
        this.nosaukums = nosaukums;
    }
    
    public String getZanrs(){
        return zanrs;
    }
    
    public void setZanrs(String zanrs){
        this.zanrs = zanrs;
    }
    
    public int getIlgumsMin(){
        return ilgumsMin;
    }
    
    public void setIlgumsMin(int ilgumsMin){
        this.ilgumsMin = ilgumsMin;
    }
    
    public String getApraksts(){
        return apraksts;
    }
    
    public void setApraksts(String apraksts){
        this.apraksts = apraksts;
    }
    
    public String toString(){
        return nosaukums + "(" + zanrs + ", " + ilgumsMin + " min)";
    }
}