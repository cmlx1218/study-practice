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

        int rs = -1;
        int wc = 0;
        int i = rs | wc;
        System.out.println(i); //-1


        System.out.println(System.nanoTime());
        //计算-1的二进制（计算机中服务要以其正值得补码形式表示）
        //00000000 00000000 00000000 00000001    原码：一个整数，按照绝对值大小转换成的二进制
        //11111111 11111111 11111111 11111110    反码：将二进制按位取反
        //11111111 11111111 11111111 11111111    补码：反码加1

        //计算0的二进制
        //00000000 00000000 00000000 00000000

        //计算 -1 | 0（只要有一个）
        //11111111 11111111 11111111 11111111
    }

}
