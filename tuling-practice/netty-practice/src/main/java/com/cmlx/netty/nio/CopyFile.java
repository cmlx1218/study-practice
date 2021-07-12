package com.cmlx.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author CMLX
 * @Date -> 2021/7/12 10:27
 * @Desc ->
 **/
public class CopyFile {

    public static void main(String[] args) throws Exception {
        String inFile = "D:\\project\\practice\\study-practice\\tuling-practice\\netty-practice\\src\\main\\java\\com\\cmlx\\netty\\nio\\CopyFile.java";
        String outFile = "D:\\project\\practice\\study-practice\\tuling-practice\\netty-practice\\src\\main\\java\\com\\cmlx\\netty\\nio\\CopyFileCopy.java";

        // 从流中获取通道
        FileInputStream fileInputStream = new FileInputStream(inFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);

        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            // 读入之前清空
            buffer.clear();
            // position自动前进
            int read = fileInputStreamChannel.read(buffer);

            if (read == -1) {
                break;
            }

            // position = 0; limit=读到的字节数
            buffer.flip();

            // 从buffer中读取
            fileOutputStreamChannel.write(buffer);
        }

    }

}
