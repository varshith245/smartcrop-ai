package com.smartcrop.backend.crop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crop")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // Rice, Wheat
    private String season;      // Kharif, Rabi
    private double yieldAmount; // tons/hectare

    private Long farmId;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getYieldAmount() {
        return yieldAmount;
    }

    public void setYieldAmount(double yieldAmount) {
        this.yieldAmount = yieldAmount;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }
}
