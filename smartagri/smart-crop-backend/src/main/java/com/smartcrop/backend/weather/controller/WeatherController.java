package com.smartcrop.backend.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.smartcrop.backend.weather.entity.Weather;
import com.smartcrop.backend.weather.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping
    public Weather save(@RequestBody Weather weather) {
        return weatherService.save(weather);
    }

    @GetMapping
    public String test() {
        return "weather ok";
    }
}
