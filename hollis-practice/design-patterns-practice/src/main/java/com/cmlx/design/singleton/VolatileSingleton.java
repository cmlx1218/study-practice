package com.cmlx.design.singleton;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 11:02
 * @Desc -> 使用volatile
 *          这种看上去完美无缺的方式也可能存在问题，那就是遇到序列化的时候
 **/
public class VolatileSingleton {

    private static volatile VolatileSingleton singleton;

    private VolatileSingleton() {
    }

    public static VolatileSingleton getSingleton() {
        if (singleton == null) {
            synchronized (VolatileSingleton.class) {
                if (singleton == null) {
                    singleton = new VolatileSingleton();
                }
            }
        }
        return singleton;
    }

}
