package com.cmlx.thread.asyncparallel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author CMLX
 * @Date -> 2021/9/22 16:38
 * @Desc ->
 **/
@Slf4j
@Service
public class TranTestService {

    @PostConstruct//启动时执行一下该方法
    @Async("taskExecutor")
    public void sendMessage1() throws InterruptedException {
        log.info("发送短信方法 ---- 1 执行开始");
        Thread.sleep(5000);
        log.info("发送短信方法 ---- 1 执行结束");
    }

    @PostConstruct//启动时执行一下该方法
    @Async("taskExecutor")
    public void sendMessage2() throws InterruptedException {
        log.info("发送短信方法 ---- 2 执行开始");
        Thread.sleep(5000);
        log.info("发送短信方法 ---- 2 执行结束");
    }

}
