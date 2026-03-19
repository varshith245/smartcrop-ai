package com.smartcrop.backend.irrigation.controller;

import com.smartcrop.backend.irrigation.dto.IrrigationRequest;
import com.smartcrop.backend.irrigation.entity.Irrigation;
import com.smartcrop.backend.irrigation.service.IrrigationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/irrigation")
public class IrrigationController {

    private final IrrigationService service;

    public IrrigationController(
            IrrigationService service
    ) {
        this.service = service;
    }

    // Add plan
    @PostMapping
    public Irrigation addPlan(
            @RequestBody IrrigationRequest request
    ) {
        return service.addPlan(request);
    }

    // Get all
    @GetMapping("/all")
    public List<Irrigation> getAll() {
        return service.getAllPlans();
    }

    // Recommend
    @PostMapping("/recommend")
    public Irrigation recommend(
            @RequestBody IrrigationRequest request
    ) {
        return service.recommend(
                request.getCropName(),
                request.getSoilType()
        );
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        service.delete(id);
    }
}
