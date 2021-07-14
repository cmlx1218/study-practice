package com.cmlx.netty.lf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class LengthFieldDecodeDemoClient {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
             }
        }
        new LengthFieldDecodeDemoClient().connect(port, "127.0.0.1");
    }

    public void connect(int port, String host) throws Exception {
        // 工作线程组 
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            // 包的最大长度（1024）、长度属性起始位、长度属性的长度、长度调解值(在总长被定义为包含包头长度时，修正信息长度)、跳过四个字节(跳过头部)
                			ch.pipeline().addLast("framer", new LengthFieldBasedFrameDecoder(1024, 0, 4, 0,4));
                			// 头部长度属性字节长度，false长度字节不算在总长度中
                			ch.pipeline().addLast("addLength", new LengthFieldPrepender(4, false));
                 			ch.pipeline().addLast(new LengthFieldDecodeDemoClientHandler());
                        }
                    });

            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            group.shutdownGracefully();
        }
    }
}