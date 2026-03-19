package com.smartcrop.backend.yield.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "yield")
public class Yield {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private String soilType;

    private double landArea; // acres

    private double expectedYield; // tons

    private double fertilizerUsed; // kg

    private double waterUsed; // liters

    private double profitEstimate; // currency

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

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public double getExpectedYield() {
        return expectedYield;
    }

    public void setExpectedYield(double expectedYield) {
        this.expectedYield = expectedYield;
    }

    public double getFertilizerUsed() {
        return fertilizerUsed;
    }

    public void setFertilizerUsed(double fertilizerUsed) {
        this.fertilizerUsed = fertilizerUsed;
    }

    public double getWaterUsed() {
        return waterUsed;
    }

    public void setWaterUsed(double waterUsed) {
        this.waterUsed = waterUsed;
    }

    public double getProfitEstimate() {
        return profitEstimate;
    }

    public void setProfitEstimate(double profitEstimate) {
        this.profitEstimate = profitEstimate;
    }
}
