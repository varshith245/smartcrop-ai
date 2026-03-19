package com.smartcrop.backend.disease.dto;

public class DiseaseRequest {

    private String cropName;
    private String symptoms;

    // Getters & Setters

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
