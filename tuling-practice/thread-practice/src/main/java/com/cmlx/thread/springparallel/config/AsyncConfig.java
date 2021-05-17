package com.cmlx.thread.springparallel.config;

import com.cmlx.thread.springparallel.exception.GlobalAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * @Author CMLX
 * @Date -> 2021/5/17 11:18
 * @Desc ->
 **/
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Autowired
    private GlobalAsyncExceptionHandler globalAsyncExceptionHandler;


    @Override
    public Executor getAsyncExecutor() {
        return null;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return globalAsyncExceptionHandler;
    }
}
