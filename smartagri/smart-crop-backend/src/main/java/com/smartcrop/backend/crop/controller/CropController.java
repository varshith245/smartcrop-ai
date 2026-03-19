package com.smartcrop.backend.crop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.smartcrop.backend.crop.entity.Crop;
import com.smartcrop.backend.crop.service.CropService;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
@RequiredArgsConstructor
public class CropController {

    private final CropService cropService;

    // Add crop
    @PostMapping
    public Crop create(@RequestBody Crop crop) {
        return cropService.save(crop);
    }

    // Get crops by farm
    @GetMapping("/farm/{farmId}")
    public List<Crop> getByFarm(@PathVariable Long farmId) {
        return cropService.getByFarm(farmId);
    }
    //@GetMapping("/test")
    //public String test() {
       // return "crop ok";
    //}
    // Get all crops
    @GetMapping
    public List<Crop> getAll() {
        return cropService.getAll();
    }

// Get by ID
    @GetMapping("/{id}")
    public Crop getById(@PathVariable Long id) {
        return cropService.getById(id);
    }

// Delete crop
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cropService.delete(id);
    }
    @PutMapping("/{id}")
public Crop update(@PathVariable Long id,
                   @RequestBody Crop crop) {
    return cropService.update(id, crop);
}


}
