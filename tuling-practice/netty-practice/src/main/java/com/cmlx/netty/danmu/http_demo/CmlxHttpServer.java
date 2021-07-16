package com.cmlx.netty.danmu.http_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

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
        EventLoopGroup work = new NioEventLoopGroup();
        bootstrap.group(boot, work);
        bootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                // pipeline.addList() handler
                // request 编码
                ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                // 将httpRequest和body(content)聚合到一起，但是如果文件很大的话是不能实现聚合的，所以这边会给一个最大值限制
                ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                // request 编码
                ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
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

    public static void main(String[] args) {

        new CmlxHttpServer().openServer(8080);

    }


    //private static class HttpServiceHandler extends SimpleChannelInboundHandler {
    //    @Override
    //    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
    //        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
    //        // 写入响应头
    //        response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=UTF-8");
    //        // 写入响应体
    //        response.content().writeBytes("cmlx is a beauty girl".getBytes());
    //        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    //    }
    //}
}
