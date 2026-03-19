package com.smartcrop.backend.recommendation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.smartcrop.backend.soil.service.SoilService;
import com.smartcrop.backend.weather.service.WeatherService;
import com.smartcrop.backend.soil.entity.SoilData;
import com.smartcrop.backend.weather.entity.Weather;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final SoilService soilService;
    private final WeatherService weatherService;

    public String getRecommendation(Long farmId) {

        SoilData soil = soilService.getByFarm(farmId);
        Weather weather = weatherService.getWeather(farmId);

        if (soil.getPh() < 6.5 &&
            weather.getRainfall() > 200) {
            return "Rice";
        }

        if (soil.getNitrogen() > 50 &&
            weather.getTemperature() < 30) {
            return "Wheat";
        }

        return "Maize";
    }
}
