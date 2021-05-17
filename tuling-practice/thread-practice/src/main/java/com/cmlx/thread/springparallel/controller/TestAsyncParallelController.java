package com.cmlx.thread.springparallel.controller;

import com.cmlx.thread.springparallel.service.IAsyncParallelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @Author CMLX
 * @Date -> 2021/5/17 11:31
 * @Desc ->
 **/
@RestController
@RequestMapping("/v1/api")
public class TestAsyncParallelController {

    @Autowired
    private IAsyncParallelService iAsyncService;

    @RequestMapping("/testAsyncParallel")
    public Long testAsync() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        String s = iAsyncService.testAsync();
        return System.currentTimeMillis() - startTime;
    }

}
