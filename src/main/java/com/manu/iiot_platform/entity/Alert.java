package com.manu.iiot_platform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String machineId;

    private String alertType; // TEMPERATURE, VIBRATION, RPM

    private String severity; // WARNING, HIGH, CRITICAL

    private String message;

    private LocalDateTime createdAt;
}