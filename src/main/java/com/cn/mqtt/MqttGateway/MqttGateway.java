package com.cn.mqtt.MqttGateway;


import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {

        void sendMessage(String data);//默认发送主题
        void sendMessage(@Header(MqttHeaders.TOPIC)String topic,String data);//指定主题发送消息
        void sendMessage(@Header(MqttHeaders.TOPIC)String topic,@Header(MqttHeaders.QOS)int qos,String data);//指定主题,指定消息级别

}











