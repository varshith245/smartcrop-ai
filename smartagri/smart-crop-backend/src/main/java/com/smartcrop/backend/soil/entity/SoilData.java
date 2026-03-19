package com.smartcrop.backend.soil.entity;

import jakarta.persistence.*;

@Entity
public class SoilData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double ph;
    private double nitrogen;
    private double phosphorus;
    private double potassium;
 @Column(name = "farm_id")
    private Long farmId;

    // ===== GETTERS =====

    public Long getId() { return id; }

    public double getPh() { return ph; }

    public double getNitrogen() { return nitrogen; }

    public double getPhosphorus() { return phosphorus; }

    public double getPotassium() { return potassium; }

    public Long getFarmId() { return farmId; }

    // ===== SETTERS =====

    public void setPh(double ph) { this.ph = ph; }

    public void setNitrogen(double nitrogen) { this.nitrogen = nitrogen; }

    public void setPhosphorus(double phosphorus) { this.phosphorus = phosphorus; }

    public void setPotassium(double potassium) { this.potassium = potassium; }

    public void setFarmId(Long farmId) { this.farmId = farmId; }
}
