package com.smartcrop.backend.reports.controller;

import com.smartcrop.backend.reports.dto.*;
import com.smartcrop.backend.reports.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/reports")
@RequiredArgsConstructor
public class AdminReportController {

    private final ReportService reportService;


    // 🌾 Farm Summary API
    @GetMapping("/farms")
    public List<FarmReportDTO> getFarmSummary() {
        return reportService.getFarmSummary();
    }


    // 🦠 Disease Report API
    @GetMapping("/diseases")
    public List<DiseaseReportDTO> getDiseaseReport() {
        return reportService.getDiseaseReport();
    }


    // 🌱 Yield Report API
    @GetMapping("/yields")
    public List<YieldReportDTO> getYieldReport() {
        return reportService.getYieldReport();
    }
}
