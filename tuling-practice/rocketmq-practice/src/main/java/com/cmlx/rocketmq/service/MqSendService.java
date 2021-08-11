package com.cmlx.rocketmq.service;

import com.cmlx.rocketmq.dto.RocketMqMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author CMLX
 * @Date -> 2021/8/9 18:33
 * @Desc ->
 **/
@Slf4j
@Component
@ConditionalOnProperty(name = "rocketmq.producer.enable", havingValue = "true")
public class MqSendService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    /**
     * 发送带tag的消息
     *
     * @param msg
     * @param topic
     * @param group
     * @param tag
     * @param <T>
     * @return
     */
    private <T> SendResult send(T msg, String topic, String group, String tag) {
        if (StringUtils.isBlank(topic) || StringUtils.isBlank(group)) {
            new Throwable("发送方topic或者group不能为空");
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        RocketMqMessage message = new RocketMqMessage();
        message.setProducerTopic(topic);
        message.setProducerGroup(group);
        message.setProducerTag(tag);
        message.setContent(msg);
        message.setMsgKey(uuid);
        // 发送消息
        Message<RocketMqMessage> messageFinal = MessageBuilder.withPayload(message).setHeader("KEYS", uuid).build();
        String destination = topic;
        if (StringUtils.isNotBlank(tag)) {
            destination = topic + ":" + tag;
        }
        SendResult result = rocketMQTemplate.syncSend(destination, messageFinal);
        log.info("成功发送消息,消息内容为:{},返回值为:{}", message, result);
        return result;
    }

    /**
     * 发送不带tag的消息
     *
     * @param msg
     * @param topic
     * @param group
     * @param <T>
     * @return
     */
    public <T> SendResult send(T msg, String topic, String group) {
        return this.send(msg, topic, group, null);
    }


}
