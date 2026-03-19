package com.smartcrop.backend.reports.dto;

public class YieldReportDTO {

    private String cropName;
    private Double avgYield;
    private Double maxYield;
    private Double minYield;

    // ===== Constructors =====

    public YieldReportDTO() {
    }

    public YieldReportDTO(String cropName,
                          Double avgYield,
                          Double maxYield,
                          Double minYield) {
        this.cropName = cropName;
        this.avgYield = avgYield;
        this.maxYield = maxYield;
        this.minYield = minYield;
    }

    // ===== Getters & Setters =====

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Double getAvgYield() {
        return avgYield;
    }

    public void setAvgYield(Double avgYield) {
        this.avgYield = avgYield;
    }

    public Double getMaxYield() {
        return maxYield;
    }

    public void setMaxYield(Double maxYield) {
        this.maxYield = maxYield;
    }

    public Double getMinYield() {
        return minYield;
    }

    public void setMinYield(Double minYield) {
        this.minYield = minYield;
    }
}
