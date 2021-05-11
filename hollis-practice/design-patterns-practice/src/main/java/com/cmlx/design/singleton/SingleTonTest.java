package com.cmlx.design.singleton;

/**
 * @Author Administrator
 * @Date -> 2021/5/11 15:49
 * @Desc -> 单例测试类
 **/
public class SingleTonTest {

    public static void main(String[] args) {

        // 简单单例
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());

        // 饿汉式只要类被加载就会创建实例，即使不会用该实例
        //String sex = Singleton2.baseStaticFieldInit();

        //Singleton2 instance2 = Singleton2.getInstance();
        //Singleton2 instance3 = Singleton2.getInstance();
        //System.out.println(instance2 == instance3);
        //System.out.println(instance2.hashCode());

    }

}
