package com.manu.iiot_platform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "machine_telemetry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MachineTelemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String machineId;

    private Double temperature;

    private Double vibration;

    private Integer rpm;

    private LocalDateTime createdAt;
}