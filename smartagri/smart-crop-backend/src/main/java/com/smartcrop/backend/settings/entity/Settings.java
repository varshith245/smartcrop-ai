package com.smartcrop.backend.settings.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private String temperatureUnit;

    private boolean rainAlert;

    private boolean irrigationAuto;

    private int moistureThreshold;

    private boolean aiCrop;

    private boolean fertilizerAI;

    private boolean diseaseAlert;

    private boolean emailAlert;

    private boolean smsAlert;
}