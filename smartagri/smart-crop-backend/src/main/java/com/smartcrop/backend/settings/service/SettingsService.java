package com.smartcrop.backend.settings.service;

import com.smartcrop.backend.settings.entity.Settings;
import com.smartcrop.backend.settings.repository.SettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingsService {

    private final SettingsRepository repository;

    public Settings get(){
        return repository.findAll().stream().findFirst().orElse(new Settings());
    }

    public Settings save(Settings settings){
        return repository.save(settings);
    }
}