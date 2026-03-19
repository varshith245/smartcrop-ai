package com.smartcrop.backend.yield.controller;

import com.smartcrop.backend.yield.dto.YieldRequest;
import com.smartcrop.backend.yield.entity.Yield;
import com.smartcrop.backend.yield.service.YieldService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yield")
public class YieldController {

    private final YieldService service;

    public YieldController(YieldService service) {
        this.service = service;
    }

    // Predict yield
    @PostMapping("/predict")
    public Yield predict(
            @RequestBody YieldRequest request
    ) {
        return service.predict(request);
    }

    // Get all records
    @GetMapping("/all")
    public List<Yield> getAll() {
        return service.getAll();
    }
}
