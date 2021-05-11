package com.cmlx.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadPkTest {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time = " + (endTime - startTime));
        System.out.println("List size = " + list.size());

    }

}
