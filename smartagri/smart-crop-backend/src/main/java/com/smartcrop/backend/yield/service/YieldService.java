package com.smartcrop.backend.yield.service;

import com.smartcrop.backend.yield.dto.YieldRequest;
import com.smartcrop.backend.yield.entity.Yield;
import com.smartcrop.backend.yield.repository.YieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YieldService {

    private final YieldRepository repository;

    public YieldService(YieldRepository repository) {
        this.repository = repository;
    }

    // Predict Yield
    public Yield predict(YieldRequest request) {

        Yield yield = new Yield();

        yield.setCropName(request.getCropName());
        yield.setSoilType(request.getSoilType());
        yield.setLandArea(request.getLandArea());
        yield.setFertilizerUsed(request.getFertilizerUsed());
        yield.setWaterUsed(request.getWaterUsed());

        // Simple AI Logic (can upgrade later)

        double baseYield =
                request.getLandArea() * 2.5;

        double fertilizerFactor =
                request.getFertilizerUsed() * 0.02;

        double waterFactor =
                request.getWaterUsed() * 0.001;

        double expected =
                baseYield
                + fertilizerFactor
                + waterFactor;

        yield.setExpectedYield(expected);

        double profit =
                expected * 20000; // price/ton

        yield.setProfitEstimate(profit);

        return repository.save(yield);
    }

    public List<Yield> getAll() {
        return repository.findAll();
    }
}
