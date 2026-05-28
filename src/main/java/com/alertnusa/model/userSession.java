/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.model;

/**
 *
 * @author edy
 */
import java.util.HashMap;
public class userSession {
    private static HashMap<String, User> userDatabase = new HashMap<>();
    private static User currentUser;
    
    public static boolean isUsernameTaken(String username) {
        return userDatabase.containsKey(username);
    }

    static {
        Admin adminUtama = new Admin("admin@gmail.com", "admin", "admin123");
        userDatabase.put(adminUtama.getUsername(), adminUtama);
        
        Member custDefault = new Member("edy@gmail.com", "edy", "edy");
        userDatabase.put(custDefault.getUsername(), custDefault);
    }
    
    // --- METHOD OVERLOADING ---

    // Overload 1: Register standar (Email, Username, Password)
    public static void addUser(String email, String username, String password) {
        User newUser = new Member(email, username, password);
        userDatabase.put(username, newUser);
    }

    // Overload 2: Register tanpa email (misal untuk Quick Signup)
    public static void addUser(String username, String password) {
        String emailDefault = username + "@example.com";
        User newUser = new User(emailDefault, username, password);
        userDatabase.put(username, newUser);
    }

    // Overload 3: Register menggunakan objek User langsung
    public static void addUser(User newUser) {
        if (newUser != null) {
            userDatabase.put(newUser.getUsername(), newUser);
        }
    }

    public static boolean login(String identifier, String password) {
        if (userDatabase.containsKey(identifier)) {
            User user = userDatabase.get(identifier);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        } else {
            for (User user : userDatabase.values()) {
                if (user.getEmail().equals(identifier) && user.getPassword().equals(password)) {
                    currentUser = user;
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean resetPassword(String username, String email, String newPassword) {
        if (userDatabase.containsKey(username)) {
            User akun = userDatabase.get(username);
            
            // Verifikasi apakah email cocok (Encapsulation: getEmail)
            if (akun.getEmail().equals(email)) {
                // Update password (Encapsulation: setPassword)
                akun.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }
    
    // Method untuk mengecek apakah ada user yang sedang login
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
    
    // Method untuk menghapus sesi user saat ini (Logout)
    public static void logout() {
        currentUser = null;
    }
}
