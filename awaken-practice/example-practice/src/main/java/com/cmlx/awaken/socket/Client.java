package com.cmlx.awaken.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author CMLX
 * @Date -> 2021/7/20 15:08
 * @Desc ->
 **/
@Slf4j
public class Client {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9000;
    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("客户端启动成功！");
                while (true) {
                    try {
                        String message = "hello cmlx!";
                        log.info("客户端发送消息：" + message);
                        socket.getOutputStream().write(message.getBytes());
                    } catch (Exception e) {
                        log.info("写数据出错！");
                    }
                    sleep();
                }
            }
        }).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
