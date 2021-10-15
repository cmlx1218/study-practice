package com.cmlx.emq;

import com.cmlx.emq.client.EmqClient;
import com.cmlx.emq.client.MqttProperties;
import com.cmlx.emq.client.QosEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class EmqxPracticeApplication {

    @Autowired
    private EmqClient emqClient;
    @Autowired
    private MqttProperties mqttProperties;

    public static void main(String[] args) {
        SpringApplication.run(EmqxPracticeApplication.class, args);

    }

    @PostConstruct
    public void init() {
        emqClient.connect(mqttProperties.getUsername(), mqttProperties.getPassword());
        //订阅某一主题
        emqClient.subscribe("testtopic/#", QosEnum.QoS2);
        ////开启一个新的线程向该主题发送消息
        //new Thread(() -> {
        //    while (true) {
        //        emqClient.publish("testtopic/123", "mqtt msg:" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), QosEnum.QoS2, false);
        //        try {
        //            TimeUnit.SECONDS.sleep(5);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //    }
        //}).start();
    }

}
