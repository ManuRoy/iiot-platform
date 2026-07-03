package com.manu.iiot_platform.service;

import com.manu.iiot_platform.dto.DashboardSummary;
import com.manu.iiot_platform.repository.AlertRepository;
import com.manu.iiot_platform.repository.DeviceRepository;
import com.manu.iiot_platform.repository.MachineTelemetryRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final DeviceRepository deviceRepository;
    private final AlertRepository alertRepository;
    private final MachineTelemetryRepository telemetryRepository;

    public DashboardService(
            DeviceRepository deviceRepository,
            AlertRepository alertRepository,
            MachineTelemetryRepository telemetryRepository) {

        this.deviceRepository = deviceRepository;
        this.alertRepository = alertRepository;
        this.telemetryRepository = telemetryRepository;
    }

    public DashboardSummary getSummary() {

        return new DashboardSummary(
                deviceRepository.count(),
                telemetryRepository.count(),
                alertRepository.count()
        );
    }
}