package com.cmlx.thread.parallel.service;

import java.util.concurrent.Future;

/**
 * @Author CMLX
 * @Date -> 2021/5/15 17:41
 * @Desc ->
 **/
public interface IMainMethodService {

    Future<String> addAsync();
    Future<String> subAsync();
    Future<String> mulAsync();
    Future<String> divAsync();

    String add();

    String sub();

    String mul();

    String div();

}
