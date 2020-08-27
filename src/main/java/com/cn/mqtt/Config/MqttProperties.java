package com.cn.mqtt.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mqtt")
public class MqttProperties {
    private MqttInboundProperties inbound;
    private MqttOutboundProperties outbound;

    public MqttProperties() {
    }

    public MqttInboundProperties getInbound() {
        return this.inbound;
    }

    public void setInbound(MqttInboundProperties inbound) {
        this.inbound = inbound;
    }

    public MqttOutboundProperties getOutbound() {
        return this.outbound;
    }

    public void setOutbound(MqttOutboundProperties outbound) {
        this.outbound = outbound;
    }
}
