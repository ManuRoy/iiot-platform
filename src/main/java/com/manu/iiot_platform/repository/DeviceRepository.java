package com.manu.iiot_platform.repository;

import com.manu.iiot_platform.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}