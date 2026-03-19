package com.smartcrop.backend.farm.entity;

import jakarta.persistence.*;
import lombok.*;
import com.smartcrop.backend.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "farms")   // keep lowercase (matches DB)
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String soilType;
    private Double area;
    private String waterSource;
    private Double latitude;
    private Double longitude;

    // ✅ REAL FK COLUMN (WRITE)
    @Column(name = "farmer_id")
    private Long farmerId;

    // ✅ RELATION (READ ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "farmer_id",
        insertable = false,
        updatable = false
    )
    @JsonIgnoreProperties({"password","otp"})
    private User farmer;


    // ===== CONSTRUCTORS =====public Farm() { }

    public Farm(Long id, String name, String location,
                String soilType, double area,
                String waterSource, Long farmerId) {

        this.id = id;
        this.name = name;
        this.location = location;
        this.soilType = soilType;
        this.area = area;
        this.waterSource = waterSource;
        this.farmerId = farmerId;
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getWaterSource() {
        return waterSource;
    }

    public void setWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }
    public Double getLatitude() {
    return latitude;
}

public void setLatitude(Double latitude) {
    this.latitude = latitude;
}

public Double getLongitude() {
    return longitude;
}

public void setLongitude(Double longitude) {
    this.longitude = longitude;
}
}