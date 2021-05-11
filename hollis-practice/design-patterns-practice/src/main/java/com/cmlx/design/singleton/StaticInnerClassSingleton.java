package com.cmlx.design.singleton;

/**
 * @Author Administrator
 * @Date -> 2021/5/11 16:06
 * @Desc -> 静态内部类实现单例模式
 *          外部类加载时不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，顾不占内存
 *          当Singleton第一次被加载时，并不需要去加载SingletonHolder，只有当getInstance()方法第一次被调用时，才会初始化INSTANCE
 *          第一次调用getInstance()方法会导致虚拟机加载SingleTonHoler类，这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化
 **/
public class StaticInnerClassSingleton {

    // 在静态内部类中初始化实例对象
    private static class SingletonHolder {
       private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    // 私有的构造方法
    private StaticInnerClassSingleton(){}

    // 对外提供获取实例的静态方法
    public static final StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
