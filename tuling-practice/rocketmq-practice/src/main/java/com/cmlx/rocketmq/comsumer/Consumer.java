package com.cmlx.rocketmq.comsumer;

import com.cmlx.rocketmq.dto.RocketMqMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author CMLX
 * @Date -> 2021/8/10 11:15
 * @Desc ->
 **/
@Slf4j
@Component
@RocketMQMessageListener(topic = "first-topic", consumerGroup = "first-producer-group")
public class Consumer implements RocketMQListener<RocketMqMessage> {

    @Override
    public void onMessage(RocketMqMessage rocketMqMessage) {
        log.info("Consumer收到了消息，消息内容是：{}", rocketMqMessage);
    }
}
