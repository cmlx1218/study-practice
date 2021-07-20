package com.cmlx.awaken.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.SSLException;

/**
 * @Author CMLX
 * @Date -> 2021/7/20 15:27
 * @Desc -> 一个简单的应答通讯实例
 **/
public class EchoClient {

    // 判断是否需要加密
    static final boolean SSL = System.getProperty("ssl") != null;
    // 监听本地服务
    static final String HOST = System.getProperty("host", "127.0.0.1");
    // 监听端口
    static final int PORT = Integer.parseInt(System.getProperty("port", "9001"));
    // 发送消息的大小，用于EchoHandler
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));


    public static void main(String[] args) throws Exception {
        //公共抽象类，安全套接字协议实现充当工厂SSLEngine和SslHandler。在内部，它通过JDK SSLContext或OpenSSL 实现SSL_CTX
        final SslContext sslCtx;
        if (SSL) {
            sslCtx = SslContextBuilder.forClient()
                    //用于验证远程端点证书的可信管理器
                    //InsecureTrustManagerFactory:在TrustManagerFactory没有任何验证的情况下信任所有X.509证书的不安全因素
                    //注：切勿TrustManagerFactory在生产中使用它。它纯粹是出于测试目的，因此非常不安全。
                    .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslCtx = null;
        }

        // 事件循环
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            if (sslCtx != null) {
                                pipeline.addLast(sslCtx.newHandler(channel.alloc(), HOST, PORT));
                            }
                            pipeline.addLast(new EchoClientHandler());
                        }
                    });
            // sync之后的代码均会执行
            ChannelFuture future = bootstrap.connect(HOST, PORT).sync();
            System.out.println("before-----");

            // 这个sync之后的代码不会执行
            future.channel().closeFuture().sync();
            System.out.println("after...");

        } finally {
            group.shutdownGracefully();
        }
    }


}
