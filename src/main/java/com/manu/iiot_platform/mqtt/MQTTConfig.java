package com.manu.iiot_platform.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MQTTConfig {

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {

        DefaultMqttPahoClientFactory factory =
                new DefaultMqttPahoClientFactory();

        MqttConnectOptions options =
                new MqttConnectOptions();

        options.setServerURIs(
                new String[]{"tcp://172.29.122.43:1883"});

        factory.setConnectionOptions(options);

        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {

        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(
                        "spring-client",
                        mqttClientFactory(),
                        "factory/telemetry"
                );

        adapter.setOutputChannel(
                mqttInputChannel());

        return adapter;
    }
}