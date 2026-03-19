package com.smartcrop.backend.soil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcrop.backend.soil.entity.SoilData;

import java.util.Optional;

public interface SoilRepository
        extends JpaRepository<SoilData, Long> {

    Optional<SoilData> findByFarmId(Long farmId);
}
