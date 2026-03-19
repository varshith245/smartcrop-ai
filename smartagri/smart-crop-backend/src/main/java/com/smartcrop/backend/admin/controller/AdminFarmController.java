package com.smartcrop.backend.admin.controller;

import com.smartcrop.backend.farm.entity.Farm;
import com.smartcrop.backend.farm.repository.FarmRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/farms")
public class AdminFarmController {

    private final FarmRepository farmRepo;

    public AdminFarmController(FarmRepository farmRepo) {
        this.farmRepo = farmRepo;
    }

    // 🌾 Get all farms
    @GetMapping
    public List<Farm> allFarms() {
        return farmRepo.findAll();
    }

    // ❌ Delete farm
    @DeleteMapping("/{id}")
    public String deleteFarm(@PathVariable Long id) {
        farmRepo.deleteById(id);
        return "Farm deleted";
    }
}
