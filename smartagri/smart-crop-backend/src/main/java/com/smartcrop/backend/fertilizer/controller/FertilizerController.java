package com.smartcrop.backend.fertilizer.controller;

import com.smartcrop.backend.fertilizer.dto.FertilizerRequest;
import com.smartcrop.backend.fertilizer.entity.Fertilizer;
import com.smartcrop.backend.fertilizer.service.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fertilizer")
@CrossOrigin("*")
public class FertilizerController {

    @Autowired
    private FertilizerService service;

    // Add fertilizer (Admin)
    @PostMapping
    public Fertilizer addFertilizer(
            @RequestBody Fertilizer fertilizer) {
        return service.addFertilizer(fertilizer);
    }

    // Get recommendation
    @PostMapping("/recommend")
    public Fertilizer recommend(
            @RequestBody FertilizerRequest request) {
        return service.recommend(request);
    }

    // Get all fertilizers
    @GetMapping("/all")
    public List<Fertilizer> getAll() {
        return service.getAll();
    }

    // Delete fertilizer
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Fertilizer Deleted Successfully";
    }
}
