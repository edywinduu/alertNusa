/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.model;
import com.alertnusa.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author edy
 */
public class PreparationRepository {
    public List<PreparationItem> getAllPreparations() {
        List<PreparationItem> list = new ArrayList<>();
        String query = "SELECT * FROM preparations";
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {

           while (rs.next()) {
               PreparationItem item = new PreparationItem();
                       
               item.setId(rs.getInt("id"));
               item.setTitle(rs.getString("title"));
               list.add(item);
           }
       } catch (SQLException e) {
           System.err.println("Gagal mengambil data preparations: " + e.getMessage());
       }
       return list;
    }
    
    public void saveUserChecklist(int userId, List<Integer> checkedIds) {
        String deleteQuery = "DELETE FROM user_preparations WHERE user_id = ?";
        String insertQuery = "INSERT INTO user_preparations (user_id, preparation_id) VALUES (?, ?)";

        try (Connection conn = com.alertnusa.util.DatabaseConnection.getConnection()) {
            // Matikan auto-commit demi keamanan data transaksi (ACID)
            conn.setAutoCommit(false);

            // Eksekusi Hapus
            try (PreparedStatement psDelete = conn.prepareStatement(deleteQuery)) {
                psDelete.setInt(1, userId);
                psDelete.executeUpdate();
            }

            // Eksekusi Insert Baru jika ada yang dicentang
            if (checkedIds != null && !checkedIds.isEmpty()) {
                try (PreparedStatement psInsert = conn.prepareStatement(insertQuery)) {
                    for (int prepId : checkedIds) {
                        psInsert.setInt(1, userId);
                        psInsert.setInt(2, prepId);
                        psInsert.addBatch(); // Gunakan batch biar cepat
                    }
                    psInsert.executeBatch();
                }
            }

            // Commit semua perubahan ke MySQL
            conn.commit();
            System.out.println("Repository: Sukses memperbarui tabel user_preparations untuk ID " + userId);

        } catch (SQLException e) {
            System.err.println("Repository Error saat simpan checklist: " + e.getMessage());
        }
    }
    
    public List<Integer> getCheckedPreparationIds(int userId) {
        List<Integer> checkedIds = new ArrayList<>();
        String query = "SELECT preparation_id FROM user_preparations WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    checkedIds.add(rs.getInt("preparation_id"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil status centang user: " + e.getMessage());
        }
        return checkedIds;
    }
    public int getPreparationPercentage(int userId) {
        int totalItems = 0;
        int completedItems = 0;

        // Query 1: Menghitung total seluruh daftar persiapan yang ada di sistem
        String queryTotal = "SELECT COUNT(*) FROM preparations";

        // Query 2: Menghitung berapa banyak item yang SUDAH DICENTANG oleh user yang sedang login
        String queryCompleted = "SELECT COUNT(*) FROM user_preparations WHERE user_id = ?";

        try (java.sql.Connection conn = com.alertnusa.util.DatabaseConnection.getConnection()) {

            // 1. Dapatkan total semua item kesiapan
            try (java.sql.PreparedStatement ps = conn.prepareStatement(queryTotal);
                 java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    totalItems = rs.getInt(1);
                }
            }

            // 2. Dapatkan jumlah item yang sudah dicentang akun ini
            try (java.sql.PreparedStatement ps = conn.prepareStatement(queryCompleted)) {
                ps.setInt(1, userId);
                try (java.sql.ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        completedItems = rs.getInt(1);
                    }
                }
            }

            // 3. Kalkulasi persentase matematika (di-cast ke int)
            if (totalItems > 0) {
                return (int) (((double) completedItems / totalItems) * 100);
            }

        } catch (Exception e) {
            System.err.println("Error hitung progress: " + e.getMessage());
        }
        return 0; // Default jika belum ada data atau eror
    }
}
