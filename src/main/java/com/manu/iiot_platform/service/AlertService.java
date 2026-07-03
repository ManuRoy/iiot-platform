package com.manu.iiot_platform.service;

import com.manu.iiot_platform.entity.Alert;
import com.manu.iiot_platform.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public Alert save(Alert alert) {
        alert.setCreatedAt(LocalDateTime.now());
        return alertRepository.save(alert);
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public List<Alert> getBySeverity(String severity) {
        return alertRepository.findBySeverity(severity);
    }
}