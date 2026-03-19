package com.smartcrop.backend.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.smartcrop.backend.weather.entity.Weather;
import com.smartcrop.backend.weather.repository.WeatherRepository;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public Weather save(Weather weather) {
        return weatherRepository.save(weather);
    }

    public Weather getWeather(Long farmId) {

        // Mock logic (replace with real API later)

        Weather w = new Weather();
        w.setRainfall(250);
        w.setTemperature(28);

        return w;
    }
}
