package com.cmlx.thread.spring.service.impl;

import com.cmlx.thread.spring.service.IAsyncService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl implements IAsyncService {

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start executeAsync");
        long startTime = System.currentTimeMillis();
        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入等耗时的事情");
        int result = 1;
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 10000; j++) {
                result = result * 2;
            }
        }
        log.info("end executeAsync, 用时=" + (System.currentTimeMillis() - startTime));
    }

}
