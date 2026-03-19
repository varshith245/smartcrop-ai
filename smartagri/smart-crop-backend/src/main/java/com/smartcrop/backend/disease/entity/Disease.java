package com.smartcrop.backend.disease.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private String diseaseName;
    private String severity;     // Low / Medium / High
    private String symptoms;

    @Column(length = 1000)
    private String treatment;

    @Column(length = 1000)
    private String pesticide;

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

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getPesticide() {
        return pesticide;
    }

    public void setPesticide(String pesticide) {
        this.pesticide = pesticide;
    }
}
