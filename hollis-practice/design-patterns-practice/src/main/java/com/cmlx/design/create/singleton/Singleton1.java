package com.cmlx.design.create.singleton;

import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @Date -> 2021/5/11 15:39
 * @Desc -> 饿汉式：在类被加载的时候就会实例化，造成不必要的消耗，因为可能这个实例根本用不到。而且类被加载多次就会造成多次实例化
 *          解决：静态内部类和懒汉式
 **/
@Component
public class Singleton1 {

    // 在类内部实例化一个实例
    private static Singleton1 instance = new Singleton1();
    // 私有的构造函数，外部无法访问
    private Singleton1(){
    }
    // 对外提供获取实例的静态方法
    public static Singleton1 getInstance() {
        return instance;
    }

}
