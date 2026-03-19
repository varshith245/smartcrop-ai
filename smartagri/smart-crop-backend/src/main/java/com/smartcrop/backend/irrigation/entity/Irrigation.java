package com.smartcrop.backend.irrigation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "irrigation")
public class Irrigation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private String soilType;

    private double waterRequirement; // liters per day

    private String irrigationMethod; // Drip / Sprinkler / Flood

    private String schedule; // e.g. Daily / Weekly

    private String recommendation;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public double getWaterRequirement() {
        return waterRequirement;
    }

    public void setWaterRequirement(double waterRequirement) {
        this.waterRequirement = waterRequirement;
    }

    public String getIrrigationMethod() {
        return irrigationMethod;
    }

    public void setIrrigationMethod(String irrigationMethod) {
        this.irrigationMethod = irrigationMethod;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
