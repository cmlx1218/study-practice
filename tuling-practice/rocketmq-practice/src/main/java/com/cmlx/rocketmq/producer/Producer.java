package com.cmlx.rocketmq.producer;

import com.cmlx.rocketmq.service.MqSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CMLX
 * @Date -> 2021/8/10 10:37
 * @Desc -> mq消息发送服务
 **/
@Slf4j
@Service
@RestController
public class Producer {

    @Autowired
    private MqSendService mqSendService;

    @GetMapping("/test-rocketmq/sendMsg")
    public String testSendMsg() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        mqSendService.send(list,"first-topic","first-producer-group");
        return "send msg success";
    }



}
