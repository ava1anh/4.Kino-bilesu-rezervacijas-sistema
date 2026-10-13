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
    private String name;
    private String username;
    private String password;
    private String passwordhash;
    private String email;
    private String role;

    public User(){
    }  
    
    public User(String name, String username, String password, String passwordhash, String email, String role){
    
        this.name = name;
        this.username = username;
        this.password = password;
        this.passwordhash = passwordhash;
        this.email = email;
        this.role = role;           
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
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPasswordhash(){
        return passwordhash;
    }
    
    public void setPasswordhash(String passwordhash){
        this.passwordhash = passwordhash;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String toString(){
        return name +" "+ username + "(" + password + ")";
    }
}