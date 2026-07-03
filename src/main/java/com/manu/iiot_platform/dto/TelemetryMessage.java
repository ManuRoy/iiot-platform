package com.manu.iiot_platform.dto;

import lombok.Data;

@Data
public class TelemetryMessage {

    private String machineId;

    private Double temperature;

    private Double vibration;

    private Integer rpm;
}