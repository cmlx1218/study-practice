package com.cmlx.thread.asyncparallel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author CMLX
 * @Date -> 2021/9/22 16:24
 * @Desc -> 线程池配置
 **/
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    /**
     * 默认情况下，在创建线程池后，线程池中的线程数为0，当任务来之后，就会创建一个线程去执行任务，
     * 当线程池中创建的线程数达到 corePoolSize之后，就会把到达的任务放到任务缓存队列当中
     * 当缓存队列满了之后，就继续创建队列，当线程数量大于等于 maxPoolSize之后，开始使用拒绝策略
     */

    // 核心线程数
    private static final int corePoolSize = 20;
    // 最大线程数
    private static final int maxPoolSize = 100;
    // 允许线程空闲时间(单位：默认秒)
    private static final int keepAliveTime = 10;
    // 缓存队列大小
    private static final int queueCapacity = 200;
    // 线程池前缀
    private static final String threadNamePrefix = "Async-Service-";

    // bean的名称，默认为首字母小写的方法名
    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);

        // 线程池对拒绝任务的处理策略
        // callerRunsPolicy：由调用线程(提交任务的线程)处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 初始化
        executor.initialize();

        return executor;

    }



}
