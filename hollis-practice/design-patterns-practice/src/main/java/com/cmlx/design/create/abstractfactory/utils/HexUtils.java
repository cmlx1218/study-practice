package com.cmlx.design.create.abstractfactory.utils;

import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;

/**
 * @Author CMLX
 * @Data -> 2021/12/17/15:14
 * @Desc ->
 */
@UtilityClass
public class HexUtils {

    public byte[] hex10To16(int valueTen) {
        System.out.println(String.format("%08X", valueTen));
        return String.format("%08X", valueTen).getBytes(StandardCharsets.UTF_8);
    }

    public byte[] hex10To8(int valueTen) {
        System.out.println(String.format("%04X", valueTen));
        return String.format("%04X", valueTen).getBytes(StandardCharsets.UTF_8);
    }

    public byte[] hex10To4(int valueTen) {
        System.out.println(String.format("%02X", valueTen));
        return String.format("%02X", valueTen).getBytes(StandardCharsets.UTF_8);
    }

    public byte[] mergeBytes(byte[]... values) {
        int lengthByte = 0;
        for (byte[] value : values) {
            lengthByte += value.length;
        }
        byte[] allBytes = new byte[lengthByte];
        int countLength = 0;
        for (byte[] b : values) {
            System.arraycopy(b, 0, allBytes, countLength, b.length);
            countLength += b.length;
        }
        return allBytes;
    }

}
