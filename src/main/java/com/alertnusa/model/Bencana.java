package com.alertnusa.model;

import java.awt.Color;

public class Bencana {
    private int id;
    private String disasterName;
    private String description; // Atribut baru
    private String category;
    private String riskLevel;

    // --- Getter dan Setter ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDisasterName() { return disasterName; }
    public void setDisasterName(String disasterName) { this.disasterName = disasterName; }

    public String getDescription() { return description; } // Getter baru
    public void setDescription(String description) { this.description = description; } // Setter baru

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
}