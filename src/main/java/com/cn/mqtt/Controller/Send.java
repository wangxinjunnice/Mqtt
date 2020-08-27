package com.cn.mqtt.Controller;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cn.mqtt.MqttGateway.MqttGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@EnableScheduling
@RestController
@RequestMapping("send")
public class Send {

    @Autowired
    private MqttGateway mqttGateway;

    private static  int count=0;

//    @Scheduled(fixedRate = 1000)
    @GetMapping("/message")
    public Object send(){

        ++count;
        for (int i = 0; i < 100; i++) {
            JSONObject object = new JSONObject();
            object.put("jpg","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");
            object.put("key","test"+i);

            mqttGateway.sendMessage("topic",JSONUtil.toJsonStr(object));
            log.error("第---------{}-----------秒,第----------{}---------条数据",count,i+1);
        }

        return "ok";

    }

}
