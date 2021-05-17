package com.cmlx.thread.parallel.service.impl;

import com.cmlx.thread.parallel.service.IParallelService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @Author CMLX
 * @Date -> 2021/5/15 17:40
 * @Desc ->
 **/
@Service
public class ParallelServiceImpl implements IParallelService {

    @Override
    public void testParallel() throws ExecutionException, InterruptedException {
        // 三个线程的线程池，核心线程=最大线程，没有临时线程，阻塞队列无界
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long startTime = System.currentTimeMillis();
        // 开启线程执行
        // 注意，此处Future对象接收线程执行结果不会阻塞，只有future.get()时候才会阻塞（直到线程执行完返回结果）
        Future future1 = executorService.submit(new SelectTask<>(this, "add"));

        Future future2 = executorService.submit(new SelectTask<>(this, "sub"));

        Future future3 = executorService.submit(new SelectTask<>(this, "mul"));

        Future future4 = executorService.submit(new SelectTask<>(this, "div"));

        //此处用循环保证三个线程执行完毕，再去拼接三个结果
        do {
            System.out.println("多任务同时执行中...");
        } while (!(future1.isDone() && future2.isDone() && future3.isDone() && future4.isDone()));

        long end = System.currentTimeMillis();
        System.out.println("并行执行：" + (end - startTime));

    }

    //任务线程类
    class SelectTask<T> implements Callable<T> {

        private Object object;
        private Object[] args;
        private String methodName;

        public SelectTask(Object object, String methodName, Object[] args) {
            this.object = object;
            this.args = args;
            this.methodName = methodName;
        }

        public SelectTask(Object object, String methodName) {
            this.object = object;
            this.methodName = methodName;
        }


        @Override
        public T call() throws Exception {
            Method method = object.getClass().getMethod(methodName, String.class);   //此处应用反射机制，String.class是根据实际方法参数设置的
            return (T) method.invoke(object);
        }
    }
}
