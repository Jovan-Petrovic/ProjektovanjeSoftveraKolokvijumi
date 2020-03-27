/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author fonis
 */
public class Custos {
    private String username;
    private String password;
    private String name;
    private String lastname;

    public Custos(String username, String password, String name, String lastname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public Custos() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
   
    
    
}
