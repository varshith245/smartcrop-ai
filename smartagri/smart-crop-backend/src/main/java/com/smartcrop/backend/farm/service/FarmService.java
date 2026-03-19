package com.smartcrop.backend.farm.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.smartcrop.backend.farm.entity.Farm;
import com.smartcrop.backend.farm.repository.FarmRepository;

@Service
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepository farmRepository;

    public Farm save(Farm farm) {
        return farmRepository.save(farm);
    }

    public List<Farm> getByFarmer(Long farmerId) {
        return farmRepository.findByFarmerId(farmerId);
    }
    public void delete(Long id) {
        farmRepository.deleteById(id);
    }
}
