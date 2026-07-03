package com.manu.iiot_platform.controller;

import com.manu.iiot_platform.entity.Alert;
import com.manu.iiot_platform.service.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @GetMapping("/severity/{severity}")
    public List<Alert> getBySeverity(
            @PathVariable String severity) {

        return alertService.getBySeverity(
                severity.toUpperCase());
    }
}