package com.smartcrop.backend.admin.dto;

public class YieldTrendDTO {

    private String cropName;
    private Double totalYield;

    public YieldTrendDTO(String cropName, Double totalYield) {
        this.cropName = cropName;
        this.totalYield = totalYield;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Double getTotalYield() {
        return totalYield;
    }

    public void setTotalYield(Double totalYield) {
        this.totalYield = totalYield;
    }
}
