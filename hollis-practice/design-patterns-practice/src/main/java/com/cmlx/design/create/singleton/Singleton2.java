package com.cmlx.design.create.singleton;

import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @Date -> 2021/5/11 15:39
 * @Desc -> 和SingleTon一样
 **/
@Component
public class Singleton2 {

    // 在类内部实例化一个实例
    private static Singleton2 instance;

    static {
        // 实例化该实例
        instance = new Singleton2();
        System.out.println("实例化SingleTon对象");
    }

    public static String baseStaticFieldInit(){
        System.out.println("父类静态变量");
        return "";
    }

    // 私有的构造函数，外部无法访问
    private Singleton2() {
    }

    // 对外提供获取实例的静态方法
    public static Singleton2 getInstance() {
        return instance;
    }

}
