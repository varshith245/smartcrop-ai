package com.smartcrop.backend.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcrop.backend.weather.entity.Weather;

public interface WeatherRepository
        extends JpaRepository<Weather, Long> {
}
