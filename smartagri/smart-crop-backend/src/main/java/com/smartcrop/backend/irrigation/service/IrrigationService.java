package com.smartcrop.backend.irrigation.service;

import com.smartcrop.backend.irrigation.dto.IrrigationRequest;
import com.smartcrop.backend.irrigation.entity.Irrigation;
import com.smartcrop.backend.irrigation.repository.IrrigationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IrrigationService {

    private final IrrigationRepository repository;

    public IrrigationService(IrrigationRepository repository) {
        this.repository = repository;
    }

    // Add irrigation plan
    public Irrigation addPlan(IrrigationRequest request) {

        Irrigation irrigation = new Irrigation();

        irrigation.setCropName(request.getCropName());
        irrigation.setSoilType(request.getSoilType());
        irrigation.setWaterRequirement(
                request.getWaterRequirement()
        );
        irrigation.setIrrigationMethod(
                request.getIrrigationMethod()
        );
        irrigation.setSchedule(request.getSchedule());
        irrigation.setRecommendation(
                request.getRecommendation()
        );

        return repository.save(irrigation);
    }

    // Get all
    public List<Irrigation> getAllPlans() {
        return repository.findAll();
    }

    // Recommend irrigation
    public Irrigation recommend(
            String crop,
            String soil
    ) {
        return repository
                .findByCropNameAndSoilType(crop, soil)
                .orElseThrow(
                        () -> new RuntimeException(
                                "No irrigation plan found"
                        )
                );
    }

    // Delete
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
