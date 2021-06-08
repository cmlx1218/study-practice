package com.cmlx.design.create.singleton;

import java.io.Serializable;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 11:16
 * @Desc -> 使用双重校验锁方式实现单例
 **/
public class Singleton implements Serializable {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }
}
