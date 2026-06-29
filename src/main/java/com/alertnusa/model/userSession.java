/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.model;
import com.alertnusa.util.DatabaseConnection;
import java.sql.*;

/**
 *
 * @author edy
 */
public class userSession {
    private static User currentUser;
    
    // Cek apakah username sudah terpakai di database MySQL
    public static boolean isUsernameTaken(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal cek username: " + e.getMessage());
        }
        return false;
    }

    // --- METHOD OVERLOADING UNTUK REGISTER (INSERT KE DATABASE) ---

    // Overload 1: Register standar (Email, Username, Password)
    public static void addUser(String email, String username, String password) {
        String query = "INSERT INTO users (email, username, password, role) VALUES (?, ?, ?, 'member')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, email);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.executeUpdate();
            System.out.println("Berhasil menambahkan member baru ke DB.");
        } catch (SQLException e) {
            System.err.println("Gagal register user (Overload 1): " + e.getMessage());
        }
    }

    // Overload 2: Register tanpa email (Quick Signup)
    public static void addUser(String username, String password) {
        String emailDefault = username + "@example.com";
        addUser(emailDefault, username, password); // Re-use Overload 1 biar tidak duplikasi query
    }

    // Overload 3: Register menggunakan objek User langsung
    public static void addUser(User newUser) {
        if (newUser == null) {
            return;
        }
        
        String role = (newUser instanceof Admin) ? "admin" : "member";
        // TAMBAHKAN KOLOM phone_number DAN domicile DI QUERY AGAR TIDAK EROR NOT NULL
        String query = "INSERT INTO users (email, username, password, role, phone_number, domicile) VALUES (?, ?, ?, ?, '', '')";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, newUser.getEmail());
            ps.setString(2, newUser.getUsername());
            ps.setString(3, newUser.getPassword());
            ps.setString(4, role);
            ps.executeUpdate();
            System.out.println("Berhasil menambahkan objek user ke DB.");
        } catch (SQLException e) {
            System.err.println("Gagal register user (Overload 3): " + e.getMessage());
        }
    }

    // Login dinamis: Membaca tabel users berdasarkan Username atau Email, cocokkan Password
    public static boolean login(String identifier, String password) {
        String query = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, identifier);
            ps.setString(2, identifier);
            ps.setString(3, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    
                    String username = rs.getString("username");
                    String role = rs.getString("role");
                    
                    // Polimorfisme instansiasi objek session
                    if ("admin".equalsIgnoreCase(role)) {
                        // FIX: Tambahkan parameter 'role' di ujung constructor
                        currentUser = new Admin(id, email, username, password, role);
                    } else {
                        // FIX: Tambahkan parameter 'role' di ujung constructor
                        currentUser = new Member(id, email, username, password, role);
                    }
                    System.out.println("Login berhasil! Sesi aktif untuk: " + username);
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal melakukan proses login: " + e.getMessage());
        }
        return false;
    }
    
    public static void loginAsGuest() {
            currentUser = null; // Menandakan bahwa yang aktif adalah Guest
            System.out.println("Masuk sebagai Guest (Sesi User Kosong).");
        }
    
    // Reset password langsung update baris di database MySQL
    public static boolean resetPassword(String username, String email, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE username = ? AND email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.setString(3, email);
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Mengembalikan true jika baris password berhasil di-update
            
        } catch (SQLException e) {
            System.err.println("Gagal mereset password di DB: " + e.getMessage());
        }
        return false;
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public static void logout() {
        currentUser = null;
        System.out.println("Sesi user telah dihapus (Logout).");
    }
}
