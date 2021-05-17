package com.cmlx.thread.parallel.service;

import java.util.concurrent.ExecutionException;

/**
 * @Author CMLX
 * @Date -> 2021/5/15 17:39
 * @Desc ->
 **/
public interface IParallelService {

    void testParallel() throws ExecutionException, InterruptedException;

}
