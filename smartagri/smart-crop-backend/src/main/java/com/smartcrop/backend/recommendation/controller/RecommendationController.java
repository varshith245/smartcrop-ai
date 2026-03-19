package com.smartcrop.backend.recommendation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.smartcrop.backend.recommendation.service.RecommendationService;

@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/{farmId}")
    public String recommend(@PathVariable Long farmId) {
        return recommendationService
                .getRecommendation(farmId);
    }
}
