package com.smartcrop.backend.settings.controller;

import com.smartcrop.backend.settings.entity.Settings;
import com.smartcrop.backend.settings.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
@RequiredArgsConstructor
public class SettingsController {

    private final SettingsService service;

    @GetMapping
    public Settings getSettings(){
        return service.get();
    }

    @PostMapping
    public Settings save(@RequestBody Settings settings){
        return service.save(settings);
    }
}