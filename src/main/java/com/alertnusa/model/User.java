/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.model;

/**
 *
 * @author edy
 */

public class User {
    private String email;
    private String username;
    private String password;

    // Constructor
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public String getRoleName() {
        return "User";
    }

    // Getter & Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}