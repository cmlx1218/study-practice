package com.cmlx.netty.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final String firstMessage;


    public EchoClientHandler() {

        firstMessage = "hello";
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("通道注册成功...");
		System.out.println("请输入消息：");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Scanner input = new Scanner(System.in);
        String next = input.next();
		System.out.println("请输入消息：");
        ctx.writeAndFlush(next + "\n");
        System.out.println("通道被激活...");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("收到服务器端消息： " + msg);
		System.out.println("请输入消息：");
        Scanner input = new Scanner(System.in);
        String next = input.next();
        ctx.write(next + "\n");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
        System.out.println("通道读取完成....");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}