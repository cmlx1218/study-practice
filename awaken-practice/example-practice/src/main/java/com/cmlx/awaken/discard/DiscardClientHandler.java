package com.cmlx.awaken.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author CMLX
 * @Date -> 2021/7/20 16:11
 * @Desc ->
 **/
public class DiscardClientHandler extends SimpleChannelInboundHandler<Object> {

    private ByteBuf content;
    private ChannelHandlerContext ctx;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;

        // 初始化消息
        content = ctx.alloc().directBuffer(DiscardClient.SIZE).writeZero(DiscardClient.SIZE);

        // 发送初始信息
        generateTraffic();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //引用计数为0，释放
        content.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 引发异常时关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        // 服务器应该不发送任何内容，但如果它发送什么，丢弃它。
    }

    // 生成数据
    private void generateTraffic(){
        // 将出站缓冲区刷新到套接字
        // 刷新后，再次生成相同数量的流量
        ctx.writeAndFlush(content.retainedDuplicate()).addListener(trafficGenerator);
    }

    // 数据触发
    private final ChannelFutureListener trafficGenerator = new ChannelFutureListener() {
        //完成操作后的方法调用，即只要成功无限调用generateTraffic()
        @Override
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()){
                generateTraffic();
            }else {
                channelFuture.cause().printStackTrace();
                channelFuture.channel().close();
            }
        }
    };
}
