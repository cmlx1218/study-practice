package com.cmlx.awaken.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author CMLX
 * @Date -> 2021/7/20 14:58
 * @Desc ->
 **/
@Slf4j
public class Server {

    private ServerSocket socket;

    public Server(int port) {
        try {
            this.socket = new ServerSocket(port);
            log.info("服务端启动成功，端口：" + port);
        } catch (IOException e) {
            log.info("服务端启动失败");
        }
    }


    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    public void doStart() {
        while (true) {
            try {
                // 阻塞方法
                Socket client = socket.accept();
                new ClientHandler(client).start();
            } catch (Exception e) {
                log.error("服务端异常");
            }
        }
    }

}
