package com.smartcrop.backend.farm.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcrop.backend.farm.entity.Farm;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    List<Farm> findByFarmerId(Long farmerId);
}
