package com.cmlx.design.create.classtest;

/**
 * @Author CMLX
 * @Date -> 2021/5/11 16:34
 * @Desc -> 全局变量设置
 **/
class Field {

    public static String baseFieldInit() {
        System.out.println("父类全局变量");
        return "";
    }

    public static String baseStaticFieldInit() {
        System.out.println("父类静态变量");
        return "";
    }


    public static String fieldInit() {
        System.out.println("子类全局变量");
        return "";
    }

    public static String staticFieldInit() {
        System.out.println("子类静态变量");
        return "";
    }
}
