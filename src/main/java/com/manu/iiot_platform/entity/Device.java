package com.manu.iiot_platform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;

    private String machineName;

    private String location;

    private String status;

    private LocalDateTime createdAt;
}