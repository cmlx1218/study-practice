package com.cmlx.thread.parallel.service.impl;

import com.cmlx.thread.parallel.service.IMainMethodService;
import org.springframework.stereotype.Service;

/**
 * @Author CMLX
 * @Date -> 2021/5/15 17:41
 * @Desc ->
 **/
@Service
public class MainMethodServiceImpl implements IMainMethodService {

    @Override
    public void add() {
        long startTime = System.currentTimeMillis();
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 10000; j++) {
                result += i;
            }
        }
        System.out.println("加法执行完毕，result=" + result + "执行时间=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void sub() {
        long startTime = System.currentTimeMillis();
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 10000; j++) {
                result -= i;
            }
        }
        System.out.println("减法执行完毕，result=" + result + "执行时间=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void mul() {
        long startTime = System.currentTimeMillis();
        int result = 1;
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 10000; j++) {
                result = result * 2;
            }
        }
        System.out.println("乘法执行完毕，result=" + result + "执行时间=" + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void div() {
        long startTime = System.currentTimeMillis();
        int result = 10000000;
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 1000; j++) {
                result = result / 2;
            }
        }
        System.out.println("除法执行完毕，result=" + result + "执行时间=" + (System.currentTimeMillis() - startTime));
    }

}
