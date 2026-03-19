package com.smartcrop.backend.crop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcrop.backend.crop.entity.Crop;

import java.util.List;

public interface CropRepository
        extends JpaRepository<Crop, Long> {

    List<Crop> findByFarmId(Long farmId);
    

}
