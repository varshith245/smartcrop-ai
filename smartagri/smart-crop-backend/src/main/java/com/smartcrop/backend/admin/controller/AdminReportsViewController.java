package com.smartcrop.backend.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminReportsViewController {

    @GetMapping("/admin/reports")
    public String reportsHome() {
        return "admin/reports/index";
    }

    @GetMapping("/admin/reports/farms")
    public String farmReports() {
        return "admin/reports/farm-reports";
    }

    @GetMapping("/admin/reports/diseases")
    public String diseaseReports() {
        return "admin/reports/disease-reports";
    }

    @GetMapping("/admin/reports/yields")
    public String yieldReports() {
        return "admin/reports/yield-reports";
    }
}
