package com.manu.iiot_platform.controller;

import com.manu.iiot_platform.entity.MachineTelemetry;
import com.manu.iiot_platform.service.TelemetryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telemetry")
public class TelemetryController {

    private final TelemetryService service;

    public TelemetryController(TelemetryService service) {
        this.service = service;
    }

    @PostMapping
    public MachineTelemetry save(@RequestBody MachineTelemetry telemetry) {
        return service.save(telemetry);
    }

    @GetMapping
    public List<MachineTelemetry> getAll() {
        return service.getAll();
    }
}