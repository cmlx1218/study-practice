package com.cmlx.netty.sticky;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;

public class StickyDemoClient {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
             }
        }
        new StickyDemoClient().connect(port, "127.0.0.1");
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
                            // 手动实现，定长读取
                            ch.pipeline().addLast("framer", new StickyDemoDecodeHandler(140));
                            // netty实现，定长读取
                            //ch.pipeline().addLast("framer", new FixedLengthFrameDecoder(140));
                            // 手动实现，#分割
               			// ch.pipeline().addLast("framer", new StickyDemoDecodeHandlerV2(
            			//		 Unpooled.wrappedBuffer(new byte[] { '#' })));
                            // netty实现，#分割
                		//	ch.pipeline().addLast("framer", new DelimiterBasedFrameDecoder(8192,
                		//			Unpooled.wrappedBuffer(new byte[] { '#' })));
                        	ch.pipeline().addLast(new StickyDemoClientHandler());

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