package com.smartcrop.backend.disease.repository;

import com.smartcrop.backend.disease.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseRepository
        extends JpaRepository<Disease, Long> {

    // 🌾 Diseases by Crop
    List<Disease> findByCropName(String cropName);

    // ⚠️ Diseases by Severity
    List<Disease> findBySeverity(String severity);
}
