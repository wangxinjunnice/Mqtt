package com.cn.mqtt.Config;

public class MqttInboundProperties {

    private String url;
    private String username;
    private String password;
    private String clientId;
    private String topics;
    private int completionTimeout;

    public MqttInboundProperties() {
    }

    public String getUrl() {
        return this.url;
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

    public String getTopics() {
        return this.topics;
    }

    public int getCompletionTimeout() {
        return this.completionTimeout;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public void setCompletionTimeout(int completionTimeout) {
        this.completionTimeout = completionTimeout;
    }

}
