package com.cmlx.thread.springparallel.service;

import java.util.concurrent.ExecutionException;

/**
 * @Author CMLX
 * @Date -> 2021/5/17 11:24
 * @Desc ->
 **/
public interface IAsyncParallelService {

    String testAsync() throws ExecutionException, InterruptedException;

}
