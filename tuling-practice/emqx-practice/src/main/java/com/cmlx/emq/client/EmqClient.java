package com.cmlx.emq.client;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author CMLX
 * @Date -> 2021/10/15 14:39
 * @Desc -> 客户端封装类
 **/
@Slf4j
@Component
public class EmqClient {

    private IMqttClient mqttClient;

    @Autowired
    private MqttProperties mqttProperties;
    @Autowired
    private MessageCallback mqttCallback;


    // 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次
    @PostConstruct
    private void init() {
        // MqttClientPersistence是接口 实现类有：MqttDefaultFilePersistence；MemoryPersistence
        MqttClientPersistence memoryPersistence = new MemoryPersistence();
        try {
            mqttClient = new MqttClient(mqttProperties.getBrokerUrl(), mqttProperties.getClientId(), memoryPersistence);
        } catch (MqttException e) {
            log.error("MqttClient初始化失败，brokerUrl={},clientId={}", mqttProperties.getBrokerUrl(), mqttProperties.getClientId());
        }
    }

    /**
     * 连接broker
     *
     * @param username
     * @param password
     */
    public void connect(String username, String password) {
        // 创建MQTT连接选项对象，可配置mqtt连接相关选项
        MqttConnectOptions connectOptions = new MqttConnectOptions();
        // 自动重连
        connectOptions.setAutomaticReconnect(true);
        /**
         * 客户端断开连接后emq不保留会话的话，否则会产生订阅共享队列的存活 客户端收不到消息的情况
         * 因为断开的连接还被保留的话，emq会将队列中的消息负载到断开但还保留的客户端，导致存活的客户 端收不到消息
         * 解决该问题有两种方案:1.连接断开后不要保持；2.保证每个客户端有固定的clientId
         */
        connectOptions.setCleanSession(true);
        connectOptions.setUserName(username);
        connectOptions.setPassword(password.toCharArray());
        // 设置mqtt消息回调
        mqttClient.setCallback(mqttCallback);
        // 连接broker
        try {
            mqttClient.connect(connectOptions);
        } catch (MqttException e) {
            log.error("连接mqtt broker失败，失败原因：{}", e.getMessage());
        }
    }

    /**
     * 发布
     *
     * @param topic
     * @param msg
     * @param qos
     * @param retain
     */
    public void publish(String topic, String msg, QosEnum qos, boolean retain) {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(qos.value());
        mqttMessage.setRetained(retain);
        mqttMessage.setPayload(msg.getBytes());
        if (mqttClient.isConnected()) {
            try {
                mqttClient.publish(topic, mqttMessage);
            } catch (MqttException e) {
                log.error("mqtt消息发布失败,topic={},msg={},qos={},retain={},errormsg= {}", topic, msg, qos, retain, e.getMessage());
            }
        }
    }

    /**
     * 订阅
     *
     * @param topicFilter
     * @param qos
     */
    public void subscribe(String topicFilter, QosEnum qos) {
        try {
            mqttClient.subscribe(topicFilter, qos.value());
        } catch (MqttException e) {
            log.error("订阅失败，topicFilter={},qos={},errormsg={}", topicFilter, qos, e.getMessage());
        }
    }

    /**
     * 断开连接
     */
    @PreDestroy
    public void disConnect() {
        try {
            mqttClient.disconnect();
        } catch (MqttException e) {
            log.error("断开连接出现异常,errormsg={}", e.getMessage());
        }
    }


}
