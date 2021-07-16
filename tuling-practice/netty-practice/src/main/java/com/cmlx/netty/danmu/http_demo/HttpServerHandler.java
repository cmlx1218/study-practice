package com.cmlx.netty.danmu.http_demo;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

/**
 * @Author CMLX
 * @Date -> 2021/7/15 17:13
 * @Desc -> http服务端自定义业务处理类
 **/
//public class HttpServerHandler implements ChannelHandler {
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//
//    }
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//
//    }
//}

//public class HttpServerHandler extends SimpleChannelInboundHandler {
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        // 获取传递过来的信息
//
//        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
//        // 写入响应头
//        response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=UTF-8");
//        // 写入响应体
//        response.content().writeBytes("丁宇杰是老色批".getBytes());
//        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
//    }

    // 用FullHttpRequest 将HttpRequest和body聚合
public class HttpServerHandler extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 大文件传输
        if (msg instanceof LastHttpContent) {
            // 获取传递过来的信息
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
            // 写入响应头
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=UTF-8");
            // 写入响应体
            response.content().writeBytes("丁宇杰是老色批".getBytes());
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }
    }
}
