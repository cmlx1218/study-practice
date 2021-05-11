package com.cmlx.design.classtest;

/**
 * @Author CMLX
 * @Date -> 2021/5/11 16:38
 * @Desc ->
 **/
class Father {

    static {
        System.out.println("父类静态代码块1");
    }

    private static String staticValue = Field.baseStaticFieldInit();

    static {
        System.out.println("父类静态代码块2");
    }

    {
        System.out.println("父类构造代码块1");
    }

    private String value = Field.baseFieldInit();

    {
        System.out.println("父类构造代码块2");
    }

    Father() {
        System.out.println("父类构造器");
    }
}
