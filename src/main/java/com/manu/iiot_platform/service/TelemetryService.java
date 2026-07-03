package com.manu.iiot_platform.service;

import com.manu.iiot_platform.entity.Alert;
import com.manu.iiot_platform.entity.MachineTelemetry;
import com.manu.iiot_platform.repository.AlertRepository;
import com.manu.iiot_platform.repository.MachineTelemetryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TelemetryService {

    private final MachineTelemetryRepository repository;
    private final AlertRepository alertRepository;

    public TelemetryService(
            MachineTelemetryRepository repository,
            AlertRepository alertRepository) {

        this.repository = repository;
        this.alertRepository = alertRepository;
    }

    public MachineTelemetry save(MachineTelemetry telemetry) {

        telemetry.setCreatedAt(LocalDateTime.now());

        MachineTelemetry saved = repository.save(telemetry);

        if (telemetry.getTemperature() > 90) {

            Alert alert = Alert.builder()
                    .machineId(telemetry.getMachineId())
                    .severity("HIGH")
                    .message("High Temperature Detected")
                    .createdAt(LocalDateTime.now())
                    .build();

            alertRepository.save(alert);
        }

        return saved;
    }

    public List<MachineTelemetry> getAll() {
        return repository.findAll();
    }
}