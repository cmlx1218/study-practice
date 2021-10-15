package com.cmlx.thread.mogu.callablefuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author CMLX
 * @Date -> 2021/9/27 20:09
 * @Desc ->
 **/
public class CallableFutureTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CallableDemo callableDemo = new CallableDemo();
        Future<Integer> submit = executorService.submit(callableDemo);
        executorService.shutdown();
        try {
            Thread.sleep(2000);
            System.out.println("主线程执行其他任务");
            if (submit.get() != null) {
                System.out.println("submit.get()-->"+submit.get());
            }else {
                System.out.println("future.get()未获取到结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行完成");
    }

}
