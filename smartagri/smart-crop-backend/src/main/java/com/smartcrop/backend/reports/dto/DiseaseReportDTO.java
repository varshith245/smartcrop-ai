package com.smartcrop.backend.reports.dto;

public class DiseaseReportDTO {

    private String cropName;
    private String diseaseName;
    private Long casesReported;

    // ===== Constructors =====

    public DiseaseReportDTO() {
    }

    public DiseaseReportDTO(String cropName, String diseaseName, Long casesReported) {
        this.cropName = cropName;
        this.diseaseName = diseaseName;
        this.casesReported = casesReported;
    }

    // ===== Getters & Setters =====

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

    public Long getCasesReported() {
        return casesReported;
    }

    public void setCasesReported(Long casesReported) {
        this.casesReported = casesReported;
    }
}
