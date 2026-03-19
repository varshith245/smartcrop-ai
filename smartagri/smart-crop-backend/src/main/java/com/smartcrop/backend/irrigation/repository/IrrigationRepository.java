package com.smartcrop.backend.irrigation.repository;

import com.smartcrop.backend.irrigation.entity.Irrigation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IrrigationRepository
        extends JpaRepository<Irrigation, Long> {

    Optional<Irrigation> findByCropNameAndSoilType(
            String cropName,
            String soilType
    );
}
