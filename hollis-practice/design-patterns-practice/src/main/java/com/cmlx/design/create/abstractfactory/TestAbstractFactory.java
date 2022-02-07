package com.cmlx.design.create.abstractfactory;

import cn.hutool.core.codec.Base64;
import com.cmlx.design.create.abstractfactory.utils.HexUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:39
 * @Desc ->
 **/
public class TestAbstractFactory {

    public static void main(String[] args) {
        //SportCarFactory sportCarFactory = new SportCarFactory();
        //BenzCar benzCar = sportCarFactory.getBenzCar();
        //benzCar.gasUp();

        //String nacos = new BCryptPasswordEncoder().encode("aimy2021#$&!");
        //System.out.println(nacos);

        //String encode = Base64.encode("cms:RongChuangMagic");
        //System.out.println(encode);
        //byte[] bytes = HexUtils.hex10To4(2);
        //byte[] bytes1 = HexUtils.hex10To4(1);
        //byte[] bytes2 = HexUtils.hex10To8(2);
        //byte[] bytes4 = HexUtils.hex10To16(5000);
        //byte[] bytes3 = HexUtils.mergeBytes(bytes, bytes1, bytes2, bytes4);
        //String s3 = HexUtils.hex10To16(5000);
        //String s4 = HexUtils.hex10To16(5000);
        //String s5 = HexUtils.hex10To16(5000);
        //String s = new String(bytes3);
        //System.out.println(s);
        //System.out.println(bytes3);
        //String url = "https://1257942285.vod2.myqcloud.com/dc8ae16fvodcq1257942285/9d5288da387702293093995054/f0.mp4";
        //String substring = url.substring(url.indexOf("/", 8) + 1);
        //String substring1 = url.substring(url.indexOf("//") + 2, url.indexOf("/", 8));
        //System.out.println(substring);
        //System.out.println(substring1);

        int i = test1();
        System.out.println(i);


    }

    public static int test1() {
        int x = 1;
        try {
            return x;
        } finally {
            x = 2;
        }
    }


}
