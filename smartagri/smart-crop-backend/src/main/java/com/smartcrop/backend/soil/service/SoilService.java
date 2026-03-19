package com.smartcrop.backend.soil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.smartcrop.backend.soil.entity.SoilData;
import com.smartcrop.backend.soil.repository.SoilRepository;

@Service
@RequiredArgsConstructor
public class SoilService {

    private final SoilRepository soilRepository;

    public SoilData save(SoilData soil) {
        return soilRepository.save(soil);
    }

    public SoilData getByFarm(Long farmId) {
        return soilRepository
                .findByFarmId(farmId)
                .orElseThrow(() ->
                        new RuntimeException("Soil not found"));
    }
}
