package com.smartcrop.backend.reports.repository;

import com.smartcrop.backend.farm.entity.Farm;
import com.smartcrop.backend.disease.entity.Disease;
import com.smartcrop.backend.yield.entity.Yield;
import com.smartcrop.backend.reports.dto.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Farm, Long> {

    // 🌾 FARM SUMMARY REPORT
    @Query("""
        SELECT new com.smartcrop.backend.reports.dto.FarmReportDTO(
            f.farmerId,
            f.location,
            f.area,
            0L
        )
        FROM Farm f
    """)
    List<FarmReportDTO> getFarmSummaryReport();


    // 🦠 DISEASE REPORT
    @Query("""
        SELECT new com.smartcrop.backend.reports.dto.DiseaseReportDTO(
            d.cropName,
            d.diseaseName,
            COUNT(d.id)
        )
        FROM Disease d
        GROUP BY d.cropName, d.diseaseName
    """)
    List<DiseaseReportDTO> getDiseaseIncidenceReport();


    // 🌱 YIELD REPORT
    @Query("""
        SELECT new com.smartcrop.backend.reports.dto.YieldReportDTO(
            y.cropName,
            AVG(y.expectedYield),
            MAX(y.expectedYield),
            MIN(y.expectedYield)
        )
        FROM Yield y
        GROUP BY y.cropName
    """)
    List<YieldReportDTO> getYieldPerformanceReport();
}
