package com.manu.iiot_platform.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardSummary {

    private long totalDevices;
    private long totalTelemetry;
    private long totalAlerts;
}