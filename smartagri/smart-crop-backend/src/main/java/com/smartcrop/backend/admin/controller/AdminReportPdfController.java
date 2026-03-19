package com.smartcrop.backend.admin.controller;

import com.smartcrop.backend.reports.dto.*;
import com.smartcrop.backend.reports.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/admin/reports")
@RequiredArgsConstructor
public class AdminReportPdfController {

    private final ReportService reportService;
    private final PdfExportService pdfExportService;


    // ================= FARM PDF =================

    @GetMapping("/farms/pdf")
    public ResponseEntity<byte[]> exportFarmPdf() {

        List<FarmReportDTO> data =
                reportService.getFarmSummary();

        ByteArrayInputStream pdf =
                pdfExportService.exportFarmReport(data);

        return buildPdfResponse(pdf, "farm-report.pdf");
    }


    // ================= DISEASE PDF =================

    @GetMapping("/diseases/pdf")
    public ResponseEntity<byte[]> exportDiseasePdf() {

        List<DiseaseReportDTO> data =
                reportService.getDiseaseReport();

        ByteArrayInputStream pdf =
                pdfExportService.exportDiseaseReport(data);

        return buildPdfResponse(pdf, "disease-report.pdf");
    }


    // ================= YIELD PDF =================

    @GetMapping("/yields/pdf")
    public ResponseEntity<byte[]> exportYieldPdf() {

        List<YieldReportDTO> data =
                reportService.getYieldReport();

        ByteArrayInputStream pdf =
                pdfExportService.exportYieldReport(data);

        return buildPdfResponse(pdf, "yield-report.pdf");
    }
    


    // ================= COMMON METHOD =================

    private ResponseEntity<byte[]> buildPdfResponse(
            ByteArrayInputStream pdf,
            String filename) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename=" + filename);

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }
    
}
