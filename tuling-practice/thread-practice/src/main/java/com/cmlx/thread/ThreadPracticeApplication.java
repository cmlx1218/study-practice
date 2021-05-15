package com.cmlx.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.cmlx.thread"})
@ServletComponentScan(basePackages = "com.cmlx.thread.logtest.listener")
public class ThreadPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadPracticeApplication.class, args);
        System.out.println("Tuling-Thread-Practice Start Success!!!");
    }

}
