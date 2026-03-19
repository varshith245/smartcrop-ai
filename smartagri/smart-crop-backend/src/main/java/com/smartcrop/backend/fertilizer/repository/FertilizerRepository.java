package com.smartcrop.backend.fertilizer.repository;

import com.smartcrop.backend.fertilizer.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FertilizerRepository
        extends JpaRepository<Fertilizer, Long> {

    Optional<Fertilizer> findByCropNameAndSoilType(
            String cropName,
            String soilType
    );
}
