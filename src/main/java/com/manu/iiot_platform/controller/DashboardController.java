package com.manu.iiot_platform.controller;

import com.manu.iiot_platform.dto.DashboardSummary;
import com.manu.iiot_platform.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/summary")
    public DashboardSummary summary() {
        return service.getSummary();
    }
}