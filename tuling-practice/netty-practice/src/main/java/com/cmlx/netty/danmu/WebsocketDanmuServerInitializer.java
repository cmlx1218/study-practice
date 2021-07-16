package com.cmlx.netty.danmu;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @Author CMLX
 * @Date -> 2021/7/16 14:51
 * @Desc -> 弹幕系统服务端处理类
 **/
public class WebsocketDanmuServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // request编码
        pipeline.addLast("http-decode", new HttpRequestDecoder());
        // 将httpRequest和body聚合，如果大文件不能聚合，所以给最大值限制
        pipeline.addLast("http-aggregator", new HttpObjectAggregator(65536));
        // response编码
        pipeline.addLast("http-encode", new HttpResponseEncoder());
        // 消息比较大的时候发送的
        pipeline.addLast("http-chunked", new ChunkedWriteHandler());

        /*
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(64*1024));
        pipeline.addLast(new ChunkedWriteHandler());
         */

        // http业务处理
        pipeline.addLast("http-request", new HttpRequestHandler("/ws"));
        // 实现websocket 协议的编码和解码
        pipeline.addLast("Websocket-protocol",new WebSocketServerProtocolHandler("/ws"));
        // 实现弹幕发送业务
        pipeline.addLast("webSocket-request",new TextWebSocketFrameHandler());


    }
}
