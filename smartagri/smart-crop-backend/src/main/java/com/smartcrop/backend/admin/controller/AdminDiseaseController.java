package com.smartcrop.backend.admin.controller;

import com.smartcrop.backend.disease.entity.Disease;
import com.smartcrop.backend.disease.repository.DiseaseRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/diseases")
public class AdminDiseaseController {

    private final DiseaseRepository diseaseRepo;

    public AdminDiseaseController(
            DiseaseRepository diseaseRepo
    ) {
        this.diseaseRepo = diseaseRepo;
    }

    // 🦠 1️⃣ All Diseases
    @GetMapping
    public List<Disease> getAllDiseases() {
        return diseaseRepo.findAll();
    }

    // 🌾 2️⃣ Diseases by Crop
    @GetMapping("/crop/{cropName}")
    public List<Disease> byCrop(
            @PathVariable String cropName
    ) {
        return diseaseRepo.findByCropName(cropName);
    }

    // ⚠️ 3️⃣ Diseases by Severity
    @GetMapping("/severity/{level}")
    public List<Disease> bySeverity(
            @PathVariable String level
    ) {
        return diseaseRepo.findBySeverity(level);
    }

    // ❌ 4️⃣ Delete Disease Record
    @DeleteMapping("/{id}")
    public String deleteDisease(
            @PathVariable Long id
    ) {
        diseaseRepo.deleteById(id);
        return "Disease record deleted";
    }
}
