package com.manu.iiot_platform.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manu.iiot_platform.dto.TelemetryMessage;
import com.manu.iiot_platform.entity.MachineTelemetry;
import com.manu.iiot_platform.repository.MachineTelemetryRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MQTTSubscriber {

    private final MachineTelemetryRepository repository;

    private final ObjectMapper mapper =
            new ObjectMapper();

    @ServiceActivator(
            inputChannel = "mqttInputChannel")
    public void receive(Message<?> message)
            throws Exception {

        String payload =
                message.getPayload().toString();

        System.out.println(
                "MQTT Received: " + payload);

        TelemetryMessage dto =
                mapper.readValue(
                        payload,
                        TelemetryMessage.class);

        MachineTelemetry telemetry =
                MachineTelemetry.builder()
                        .machineId(dto.getMachineId())
                        .temperature(dto.getTemperature())
                        .vibration(dto.getVibration())
                        .rpm(dto.getRpm())
                        .createdAt(LocalDateTime.now())
                        .build();

        repository.save(telemetry);

        System.out.println(
                "Saved to PostgreSQL");
    }
}