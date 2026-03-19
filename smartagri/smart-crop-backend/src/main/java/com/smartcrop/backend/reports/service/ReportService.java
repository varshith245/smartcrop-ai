package com.smartcrop.backend.reports.service;

import com.smartcrop.backend.reports.dto.*;
import com.smartcrop.backend.reports.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;


    // 🌾 Farm Summary
    public List<FarmReportDTO> getFarmSummary() {
        return reportRepository.getFarmSummaryReport();
    }


    // 🦠 Disease Incidence
    public List<DiseaseReportDTO> getDiseaseReport() {
        return reportRepository.getDiseaseIncidenceReport();
    }


    // 🌱 Yield Performance
    public List<YieldReportDTO> getYieldReport() {
        return reportRepository.getYieldPerformanceReport();
    }
}
