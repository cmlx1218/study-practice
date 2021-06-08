package com.cmlx.design.create.singleton;

/**
 * @Author CMLX
 * @Date -> 2021/5/11 20:48
 * @Desc -> 双重校验锁：通过同步代码块的方式减小了锁的范围，大大提高效率
 *          使用双重检查锁有潜在的危险，有时会正常工作（区分正确实现和有小问题的实现是很困难的。
 *          取决于编译器，线程的调度和其他并发系统活动，不正确的实现双重检查锁导致的异常结果可能会间歇性出现。重现异常是十分困难的。
 **/
public class Singleton5 {

    // 定义实例
    private static Singleton5 instance;

    // 私有构造方法
    private Singleton5() {
    }

    // 对外提供获取实例的静态方法
    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                // 在对象被使用的时候才实例化
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
