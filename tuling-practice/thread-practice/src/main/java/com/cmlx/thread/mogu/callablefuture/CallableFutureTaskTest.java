package com.cmlx.thread.mogu.callablefuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author CMLX
 * @Date -> 2021/9/27 20:14
 * @Desc ->
 **/
public class CallableFutureTaskTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(callableDemo);
        executorService.submit(futureTask);
        //Future<Integer> submit = executorService.submit(callableDemo);
        executorService.shutdown();
        try {
            Thread.sleep(2000);
            System.out.println("主线程执行其他任务");
            if (futureTask.get() != null) {
                System.out.println("submit.get()-->"+futureTask.get());
            }else {
                System.out.println("future.get()未获取到结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行完成");
    }

}
