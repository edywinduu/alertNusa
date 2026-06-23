package com.alertnusa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.alertnusa.util.DatabaseConnection;

public class BencanaRepository {
    public List<Bencana> getAllDisasters() {
        List<Bencana> list = new ArrayList<>();
        // Pastikan memanggil kolom description
        String query = "SELECT id, disaster_name, description, category, risk_level FROM disasters";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Bencana b = new Bencana();
                b.setId(rs.getInt("id"));
                b.setDisasterName(rs.getString("disaster_name"));
                b.setDescription(rs.getString("description")); // Masukkan data ke model
                b.setCategory(rs.getString("category"));
                b.setRiskLevel(rs.getString("risk_level"));
                list.add(b);
            }
        } catch (Exception e) {
            System.err.println("Error load data disasters: " + e.getMessage());
        }
        return list;
    }
}