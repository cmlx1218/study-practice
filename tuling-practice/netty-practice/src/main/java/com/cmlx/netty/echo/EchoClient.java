package com.cmlx.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * https://www.cnblogs.com/qdhxhz/p/10234908.html
 */
public final class EchoClient {
 
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8040"));

    public static void main(String[] args) throws Exception {

         EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .option(ChannelOption.TCP_NODELAY, true)
             .handler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 public void initChannel(SocketChannel ch) throws Exception {
                     ChannelPipeline p = ch.pipeline();
                     // addLast(...)   //在ChannelPipeline的末尾添加ChannelHandler
                     // addFirst(...)   //添加ChannelHandler在ChannelPipeline的第一个位置
                     // addBefore(...)   //在ChannelPipeline中指定的ChannelHandler名称之前添加ChannelHandler
                     // addAfter(...)   //在ChannelPipeline中指定的ChannelHandler名称之后添加ChannelHandler
                     // remove(...)   //删除ChannelPipeline中指定的ChannelHandler
                     // replace(...)   //替换ChannelPipeline中指定的ChannelHandle
                	 p.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                     p.addLast("decoder", new StringDecoder());
                     p.addLast("encoder", new StringEncoder());
                     p.addLast(new EchoClientHandler());
                 }
             });

            // 启动客户端
            ChannelFuture f = b.connect(HOST, PORT).sync();

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            group.shutdownGracefully();
        }
    }
}
