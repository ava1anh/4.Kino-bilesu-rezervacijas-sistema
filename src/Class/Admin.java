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
    private String rights;
    
    public Admin(){
    }
    
    public Admin(int userId, String rights){
        this.userId = userId;
        this.rights = rights;
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
    
    public String getRights(){
        return rights;
    }
    
    public void setRights(String rights){
        this.rights = rights;
    }
}
