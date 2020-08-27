package com.cn.mqtt.MqttInboundAndOutbound;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.mqtt.Config.MqttProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.util.HashMap;
import java.util.Map;

/**
 * 消费者
 */

@Configuration
@Slf4j
@ConditionalOnProperty(prefix = "spring", name = "mqtt.enabled", havingValue = "true")
public class MqttInboundConfiguration {

    @Autowired
    private MqttProperties mqttProperties;


    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound(){

        String[] inboundTopics  = mqttProperties.getInbound().getTopics().split(",");
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(mqttProperties.getInbound().getUrl(),mqttProperties.getInbound().getClientId(),inboundTopics);

        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;

    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler(){
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {

                String topic = message.getHeaders().get("mqtt_receivedTopic").toString();

                JSONObject obj = JSON.parseObject((String) message.getPayload());

                String[] split = mqttProperties.getInbound().getTopics().split(",");

                if(topic.equals(split[0])){
                    String string = (String) obj.get("key");
                    String jpg = (String) obj.get("jpg");
                    System.out.println("topic1---------->"+obj.toJSONString());
                }

                if(topic.equals(split[1])){
                    String string = (String) obj.get("key");

                    System.out.println("topic2---------->"+string);
                }
            }
        };
    }
}
