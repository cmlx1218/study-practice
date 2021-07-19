package com.cmlx.rpc.server;

import com.cmlx.netty.rpc.server.RpcService;
import com.cmlx.rpc.api.IHelloService;

/**
 * @Author CMLX
 * @Date -> 2021/7/19 16:03
 * @Desc ->
 **/
@RpcService(IHelloService.class)
public class HelloServiceImpl implements IHelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name + "!";
    }
}
