package com.cmlx.rocketmq.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author CMLX
 * @Date -> 2021/8/9 18:29
 * @Desc -> 消息实体
 **/
@Data
public class RocketMqMessage<T> implements Serializable {

    /**
     * 消息内容
     */
    private T content;
    /**
     * 消息的key
     */
    private String msgKey;
    /**
     * topic
     */
    private String producerTopic;
    /**
     * group
     */
    private String producerGroup;
    /**
     * tag
     */
    private String producerTag;

}
