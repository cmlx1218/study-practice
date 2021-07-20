package com.cmlx.awaken.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.Socket;

/**
 * @Author CMLX
 * @Date -> 2021/7/20 15:02
 * @Desc ->
 **/
@Slf4j
public class ClientHandler {

    public static final int MAX_DATA_LEN = 1024;
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        log.info("新客户端接入");
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    public void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    log.info("客户端传来消息：" + message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
