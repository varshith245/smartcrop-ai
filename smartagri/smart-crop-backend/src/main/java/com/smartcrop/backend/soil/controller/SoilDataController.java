package com.smartcrop.backend.soil.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.smartcrop.backend.soil.entity.SoilData;
import com.smartcrop.backend.soil.service.SoilService;

@RestController
@RequestMapping("/api/soil")
@RequiredArgsConstructor
public class SoilDataController {

    private final SoilService soilService;

    @PostMapping
    public SoilData create(@RequestBody SoilData soil) {
        return soilService.save(soil);
    }

    @GetMapping("/farm/{id}")
    public SoilData getByFarm(@PathVariable Long id) {
        return soilService.getByFarm(id);
    }

    @GetMapping
    public String test() {
        return "soil ok";
    }
}
