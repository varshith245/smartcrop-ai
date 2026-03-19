package com.smartcrop.backend.admin.service;

import com.smartcrop.backend.admin.dto.YieldAnalytics;
import com.smartcrop.backend.admin.dto.YieldTrendDTO;
import com.smartcrop.backend.yield.entity.Yield;
import com.smartcrop.backend.yield.repository.YieldRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AdminYieldService {

    private final YieldRepository yieldRepo;

    public AdminYieldService(YieldRepository yieldRepo) {
        this.yieldRepo = yieldRepo;
    }

    // 📊 Get All Yield Records
    public List<Yield> getAll() {
        return yieldRepo.findAll();
    }
    public List<YieldTrendDTO> trend() {
    return yieldRepo.getYieldTrend();
}

    public Yield byId(Long id) {
    return yieldRepo.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Yield record not found"));
}


    // 🌾 Yield by Crop
    public List<Yield> byCrop(String cropName) {
        return yieldRepo.findByCropName(cropName);
    }

    // 💰 Top Profitable Crops
    public List<Yield> topProfits() {
        return yieldRepo.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(Yield::getProfitEstimate).reversed())
                .limit(5)
                .toList();
    }
   

    // 📈 Analytics Summary
    public YieldAnalytics analytics() {

        List<Yield> list = yieldRepo.findAll();

        long totalRecords = list.size();

        double totalYield = list.stream()
                .mapToDouble(Yield::getExpectedYield)
                .sum();

        double totalProfit = list.stream()
                .mapToDouble(Yield::getProfitEstimate)
                .sum();

        double avgYield =
                totalRecords == 0 ? 0 : totalYield / totalRecords;

        return new YieldAnalytics(
                totalRecords,
                totalYield,
                totalProfit,
                avgYield
        );
    }
}
