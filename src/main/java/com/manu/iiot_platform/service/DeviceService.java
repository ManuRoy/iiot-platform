package com.manu.iiot_platform.service;

import com.manu.iiot_platform.entity.Device;
import com.manu.iiot_platform.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public Device save(Device device) {

        device.setCreatedAt(LocalDateTime.now());

        return repository.save(device);
    }

    public List<Device> getAll() {
        return repository.findAll();
    }
}