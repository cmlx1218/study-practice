package com.cmlx.netty.danmu.http_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;

/**
 * @Author CMLX
 * @Date -> 2021/7/15 16:58
 * @Desc -> http服务端
 **/
public class CmlxHttpServer {

    public void openServer(int port) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.channel(NioServerSocketChannel.class);
        EventLoopGroup boot = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup(8);
        bootstrap.group(boot, work);
        bootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                // pipeline.addList() handler
                // request 编码
                ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                // request 编码
                ch.pipeline().addLast("http-encoder", new HttpRequestEncoder());
                // 自定义业务处理
                ch.pipeline().addLast("http-server", new HttpServerHandler());
            }
        });
        try {
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("服务已启动" + port);
            // 等待管道关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
