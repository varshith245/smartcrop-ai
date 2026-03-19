package com.smartcrop.backend.settings.repository;

import com.smartcrop.backend.settings.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepository extends JpaRepository<Settings,Long> {
}