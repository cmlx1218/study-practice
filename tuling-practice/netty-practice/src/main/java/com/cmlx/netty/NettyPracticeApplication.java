package com.cmlx.netty;

import com.cmlx.netty.lf.test.Group;
import com.cmlx.netty.lf.test.ProtostuffUtils;
import com.cmlx.netty.lf.test.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class NettyPracticeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NettyPracticeApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        // 创建User对象
        User user = User.builder().id("1").age(20).name("张三").desc("programmer").build();
        // 创建Group对象
        Group group = Group.builder().id("1").name("分组1").user(user).build();
        // 使用ProtostuffUtils序列化和反序列化
        byte[] serialize = ProtostuffUtils.serialize(group);
        System.out.println("序列化之后：" + Arrays.toString(serialize));
        Group deserialize = ProtostuffUtils.deserialize(serialize, Group.class);
        System.out.println("反序列化之后：" + deserialize.toString());
    }
}
