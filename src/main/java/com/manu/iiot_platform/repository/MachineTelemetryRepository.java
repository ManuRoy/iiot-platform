package com.manu.iiot_platform.repository;

import com.manu.iiot_platform.entity.MachineTelemetry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineTelemetryRepository
        extends JpaRepository<MachineTelemetry, Long> {
}