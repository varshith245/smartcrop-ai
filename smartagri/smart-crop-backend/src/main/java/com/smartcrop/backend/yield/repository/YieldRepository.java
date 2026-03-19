package com.smartcrop.backend.yield.repository;

import com.smartcrop.backend.admin.dto.YieldTrendDTO;
import com.smartcrop.backend.yield.entity.Yield;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface YieldRepository
        extends JpaRepository<Yield, Long> {

    List<Yield> findByCropName(String cropName);
    @Query("""
           SELECT new com.smartcrop.backend.admin.dto.YieldTrendDTO(
               y.cropName,
               SUM(y.expectedYield)
           )
           FROM Yield y
           GROUP BY y.cropName
           ORDER BY SUM(y.expectedYield) DESC
           """)
    List<YieldTrendDTO> getYieldTrend();
}
