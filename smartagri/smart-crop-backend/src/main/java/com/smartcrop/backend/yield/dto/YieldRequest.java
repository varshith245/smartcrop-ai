package com.smartcrop.backend.yield.dto;

public class YieldRequest {

    private String cropName;
    private String soilType;
    private double landArea;
    private double fertilizerUsed;
    private double waterUsed;

    // Getters & Setters

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
}
