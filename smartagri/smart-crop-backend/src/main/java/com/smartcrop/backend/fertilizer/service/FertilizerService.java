package com.smartcrop.backend.fertilizer.service;

import com.smartcrop.backend.fertilizer.dto.FertilizerRequest;
import com.smartcrop.backend.fertilizer.entity.Fertilizer;
import com.smartcrop.backend.fertilizer.repository.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizerService {

    @Autowired
    private FertilizerRepository repository;

    // Add fertilizer
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return repository.save(fertilizer);
    }

    // Recommendation logic
    public Fertilizer recommend(FertilizerRequest request) {

        return repository
                .findByCropNameAndSoilType(
                        request.getCropName(),
                        request.getSoilType()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "No fertilizer recommendation found"));
    }

    // Get all fertilizers
    public List<Fertilizer> getAll() {
        return repository.findAll();
    }

    // Delete fertilizer
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
