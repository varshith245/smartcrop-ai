package com.smartcrop.backend.fertilizer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fertilizers")
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "crop_name")
    private String cropName;

    @Column(name = "soil_type")
    private String soilType;

    private double nitrogen;
    private double phosphorus;
    private double potassium;

    @Column(length = 2000)
    private String recommendation;

    // Constructors
    public Fertilizer() {}

    public Fertilizer(String cropName, String soilType,
                      double nitrogen, double phosphorus,
                      double potassium, String recommendation) {
        this.cropName = cropName;
        this.soilType = soilType;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
        this.recommendation = recommendation;
    }

    // Getters & Setters

    public Long getId() { return id; }

    public String getCropName() { return cropName; }
    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public double getNitrogen() { return nitrogen; }
    public void setNitrogen(double nitrogen) {
        this.nitrogen = nitrogen;
    }

    public double getPhosphorus() { return phosphorus; }
    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getPotassium() { return potassium; }
    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
