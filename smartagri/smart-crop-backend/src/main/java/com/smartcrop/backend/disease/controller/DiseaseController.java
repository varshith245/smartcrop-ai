package com.smartcrop.backend.disease.controller;

import com.smartcrop.backend.disease.dto.DiseaseRequest;
import com.smartcrop.backend.disease.entity.Disease;
import com.smartcrop.backend.disease.service.DiseaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

    private final DiseaseService service;

    public DiseaseController(DiseaseService service) {
        this.service = service;
    }

    // 🔍 Predict Disease
    @PostMapping("/predict")
    public Disease predict(
            @RequestBody DiseaseRequest request
    ) {
        return service.predict(request);
    }

    // 📜 Get All
    @GetMapping("/all")
    public List<Disease> getAll() {
        return service.getAll();
    }

    // 🔎 Get By ID
    @GetMapping("/{id}")
    public Disease getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // ❌ Delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}
