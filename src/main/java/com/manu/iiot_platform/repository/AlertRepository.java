package com.manu.iiot_platform.repository;

import com.manu.iiot_platform.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {

    List<Alert> findBySeverity(String severity);
}