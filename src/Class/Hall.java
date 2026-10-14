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
    private String name;
    private int  placesNumber;
    
    public Hall(String name, int placesNumber){
        this.name = name;
        this.placesNumber= placesNumber;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getPlacesNumber(){
        return placesNumber;
    }
    
    public void setPlacesNumber(int placesNumber){
        this.placesNumber = placesNumber;
    }
    
    public String toString(){
        return name + "(" + placesNumber + " vietas)";
    }
}
