package com.cmlx.netty.danmu;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author CMLX
 * @Date -> 2021/7/16 14:40
 * @Desc -> 弹幕系统服务端
 **/
public class WebsocketDanmuServer {

    private int port;

    private WebsocketDanmuServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(2);
        EventLoopGroup workerGroup = new NioEventLoopGroup(3);
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new WebsocketDanmuServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            System.out.println("Danmu系统Server端启动成功了,端口号》》》" + port);

            // 绑定端口，开始接收进来的连接
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            // 等待服务器  socket关闭
            // 本例子中不会发生，但可以优雅关闭服务器
            channelFuture.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            System.out.println("Danmu系统Server端启动关闭了");
        }

    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8088;
        }
        new WebsocketDanmuServer(port).run();
    }

}
