package com.cmlx.thread.springparallel.service.impl;

import com.cmlx.thread.parallel.service.IMainMethodService;
import com.cmlx.thread.parallel.service.impl.MainMethodServiceImpl;
import com.cmlx.thread.springparallel.service.IAsyncParallelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author CMLX
 * @Date -> 2021/5/17 11:26
 * @Desc ->
 **/
@Service
public class AsyncParallelServiceImpl implements IAsyncParallelService {

    @Autowired
    private IMainMethodService mainMethodService;

    @Override
    public String testAsync() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        Future<String> stringFuture = mainMethodService.addAsync();
        Future<String> stringFuture1 = mainMethodService.subAsync();
        Future<String> stringFuture2 = mainMethodService.mulAsync();
        Future<String> stringFuture3 = mainMethodService.divAsync();
        String add = stringFuture.get();
        String sub = stringFuture1.get();
        String mul = stringFuture2.get();
        String div = stringFuture3.get();

        System.out.println("并行执行耗时：" + (System.currentTimeMillis() - startTime));
        return add + sub + mul + div;
    }
}
