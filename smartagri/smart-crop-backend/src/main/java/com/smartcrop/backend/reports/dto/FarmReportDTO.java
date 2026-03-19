package com.smartcrop.backend.reports.dto;

public class FarmReportDTO {

    private Long farmerId;
    private String location;
    private Double area;
    private Long cropCount;

    // ===== Constructors =====

    public FarmReportDTO() {
    }

    public FarmReportDTO(Long farmerId, String location, Double area, Long cropCount) {
        this.farmerId = farmerId;
        this.location = location;
        this.area = area;
        this.cropCount = cropCount;
    }

    // ===== Getters & Setters =====

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Long getCropCount() {
        return cropCount;
    }

    public void setCropCount(Long cropCount) {
        this.cropCount = cropCount;
    }
}
