package com.cmlx.rpc.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author CMLX
 * @Date -> 2021/7/20 12:04
 * @Desc ->
 **/
@Slf4j
public class RpcBootstrap {

    public static void main(String[] args) {
        log.info("start server");
        new ClassPathXmlApplicationContext("spring.xml");
    }

}
