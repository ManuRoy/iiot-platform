package com.manu.iiot_platform.controller;

import com.manu.iiot_platform.entity.Device;
import com.manu.iiot_platform.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @PostMapping
    public Device save(@RequestBody Device device) {
        return service.save(device);
    }

    @GetMapping
    public List<Device> getAll() {
        return service.getAll();
    }
}