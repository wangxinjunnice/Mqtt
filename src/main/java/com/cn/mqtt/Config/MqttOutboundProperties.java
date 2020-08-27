package com.cn.mqtt.Config;

public class MqttOutboundProperties {

    private String urls;
    private String username;
    private String password;
    private String clientId;
    private String topic;

    public MqttOutboundProperties() {
    }

    public String getUrls() {
        return this.urls;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
