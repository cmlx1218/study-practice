package com.cmlx.thread.thread01;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Callable01 implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "赤名莉香";
    }

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new Callable01());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());

    }
}
