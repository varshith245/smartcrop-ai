package com.smartcrop.backend.farm.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.smartcrop.backend.farm.entity.Farm;
import com.smartcrop.backend.farm.service.FarmService;

@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    // ================= CREATE FARM =================
    @PostMapping
    public Farm create(@RequestBody Farm farm) {

        // Get logged-in user from SecurityContext
        String userIdStr =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        Long farmerId = Long.parseLong(userIdStr);

        farm.setFarmerId(farmerId);

        return farmService.save(farm);
    }

    // ================= GET MY FARMS =================
    @GetMapping("/my")
public List<Farm> getMyFarms() {

    String userIdStr =
        SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getName();

    Long farmerId =
        Long.parseLong(userIdStr);

    return farmService.getByFarmer(farmerId);
}

    // ================= DELETE =================
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        farmService.delete(id);
        return "Farm deleted";
    }

    // ================= UPDATE =================
    @PutMapping("/{id}")
    public Farm update(
            @PathVariable Long id,
            @RequestBody Farm farm) {

        farm.setId(id);
        return farmService.save(farm);
    }
}