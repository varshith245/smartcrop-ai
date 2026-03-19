package com.smartcrop.backend.admin.controller;

import com.smartcrop.backend.crop.entity.Crop;
import com.smartcrop.backend.crop.repository.CropRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/crops")
public class AdminCropController {

    private final CropRepository cropRepo;

    public AdminCropController(CropRepository cropRepo) {
        this.cropRepo = cropRepo;
    }

    // 🌾 1️⃣ Get All Crops
    @GetMapping
    public List<Crop> getAllCrops() {
        return cropRepo.findAll();
    }

    // 🧑‍🌾 2️⃣ Get Crops by Farmer ID
    @GetMapping("/farmer/{farmerId}")
    public List<Crop> getCropsByFarmer(
            @PathVariable Long farmerId
    ) {
        return cropRepo.findByFarmId(farmerId);
    }

    // ❌ 3️⃣ Delete Crop
    @DeleteMapping("/{id}")
    public String deleteCrop(@PathVariable Long id) {

        Crop crop = cropRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Crop not found"));

        cropRepo.delete(crop);

        return "Crop deleted successfully";
    }
}
