package com.cmlx.awaken.socket;

/**
 * @Author CMLX
 * @Date -> 2021/7/20 14:58
 * @Desc ->
 **/
public class ServerBoot {

    private static final int PORT = 9000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }


}
