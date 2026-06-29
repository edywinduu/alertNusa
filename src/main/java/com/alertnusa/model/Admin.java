/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.model;

/**
 *
 * @author edy
 */
public class Admin extends User {
    public Admin(int id, String email, String username, String password, String role) {
        super(id, email, username, password, role); // <-- Oper id ke super constructor
    }

    @Override
    public String getRoleName() {
        return "Admin";
    }
}
