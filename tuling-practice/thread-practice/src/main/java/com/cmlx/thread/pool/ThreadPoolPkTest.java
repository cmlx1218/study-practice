package com.cmlx.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolPkTest {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            final int j = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(j);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        long endTime = System.currentTimeMillis();
        System.out.println("Time = " + (endTime - startTime));
        System.out.println("List size = " + list.size());
    }

}
