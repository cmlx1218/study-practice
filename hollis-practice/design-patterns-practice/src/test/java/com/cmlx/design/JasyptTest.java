package com.cmlx.design;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author CMLX
 * @Data -> 2022/01/19/15:57
 * @Desc ->
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DesignPatternsPracticeApplication.class)
public class JasyptTest {

    @Autowired
    private StringEncryptor encryptor;
    @Value("${jasypt.test}")
    private String port;

    @Test
    public void JasyptDemoTest() {
        String encrypt = encryptor.encrypt("cmlx1218");
        System.out.println(encrypt);
        System.out.println(port);
    }



}
