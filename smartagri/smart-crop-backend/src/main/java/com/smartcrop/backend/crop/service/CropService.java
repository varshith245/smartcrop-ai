package com.smartcrop.backend.crop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.smartcrop.backend.crop.entity.Crop;
import com.smartcrop.backend.crop.repository.CropRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropService {

    private final CropRepository cropRepository;

    public Crop save(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getByFarm(Long farmId) {
        return cropRepository.findByFarmId(farmId);
    }
    public List<Crop> getAll() {
        return cropRepository.findAll();
    }

    public Crop getById(Long id) {
        return cropRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Crop not found"));
    }

    public void delete(Long id) {
        cropRepository.deleteById(id);
    }
    public Crop update(Long id, Crop crop) {

    Crop existing = cropRepository.findById(id)
            .orElseThrow();

    existing.setName(crop.getName());
    existing.setSeason(crop.getSeason());
    existing.setYieldAmount(crop.getYieldAmount());
    existing.setFarmId(crop.getFarmId());

    return cropRepository.save(existing);
}

}
