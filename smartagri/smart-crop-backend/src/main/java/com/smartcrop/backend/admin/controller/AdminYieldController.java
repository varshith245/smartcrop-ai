package com.smartcrop.backend.admin.controller;

import com.smartcrop.backend.admin.dto.YieldAnalytics;
import com.smartcrop.backend.admin.service.AdminYieldService;
import com.smartcrop.backend.yield.entity.Yield;
import org.springframework.web.bind.annotation.*;
import com.smartcrop.backend.admin.dto.YieldTrendDTO;


import java.util.List;

@RestController
@RequestMapping("/api/admin/yield")
public class AdminYieldController {

    private final AdminYieldService service;

    public AdminYieldController(AdminYieldService service) {
        this.service = service;
    }

    // 📊 All Yield Records
    @GetMapping
    public List<Yield> all() {
        return service.getAll();
    }

    // 🔍 Yield by ID
@GetMapping("/{id}")
public Yield byId(@PathVariable Long id) {
    return service.byId(id);
}


    // 🌾 Yield by Crop
    @GetMapping("/crop/{name}")
    public List<Yield> byCrop(@PathVariable String name) {
        return service.byCrop(name);
    }

    // 💰 Top Profitable Crops
    @GetMapping("/profit/top")
    public List<Yield> topProfits() {
        return service.topProfits();
    }

    // 📈 Analytics Summary
    @GetMapping("/analytics")
    public YieldAnalytics analytics() {
        return service.analytics();
    }
    @GetMapping("/trend")
public List<YieldTrendDTO> trend() {
    return service.trend();
}

}
