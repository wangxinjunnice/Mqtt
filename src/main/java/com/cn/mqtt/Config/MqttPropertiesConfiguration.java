package com.cn.mqtt.Config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({MqttProperties.class})
public class MqttPropertiesConfiguration {
    public MqttPropertiesConfiguration() {
    }
}
