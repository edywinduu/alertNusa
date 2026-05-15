/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.model;

/**
 *
 * @author edy
 */
public class Member extends User{
    public Member(String email, String username, String password) {
        super(email, username, password);
    }

    @Override
    public String getRoleName() {
        return "Member";
    }
}