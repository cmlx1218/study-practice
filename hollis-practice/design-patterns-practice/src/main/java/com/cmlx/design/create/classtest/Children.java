package com.cmlx.design.create.classtest;

/**
 * @Author CMLX
 * @Date -> 2021/5/11 16:42
 * @Desc ->
 **/
public class Children extends Father {

    static {
        System.out.println("子类静态代码块1");
    }

    public static String staticValue = Field.staticFieldInit();

    static {
        System.out.println("子类静态代码块2");
    }

    {
        System.out.println("子类构造代码块1");
    }

    private String value = Field.fieldInit();

    {
        System.out.println("子类构造代码块2");
    }

    public Children() {
        System.out.println("子类无参构造器");
    }

    public static String bed() {
        System.out.println("静态方法");
        return "";
    }

    private static class House {
        private static Children houseChildren = new Children();
    }

    public static void main(String[] args) {
        //Children children = new Children();
        //System.out.println("Children:" + children);
        //System.out.println("********************************");
        //
        //Children children1 = new Children();
        //System.out.println("Children:" + children1);
        //System.out.println("********************************");

        Children house = House.houseChildren;
        System.out.println("ChildrenHouse:" + house);
        System.out.println("*******************************");
        Children house1 = House.houseChildren;
        System.out.println("ChildrenHouse:" + house1);
        System.out.println("*******************************");
    }
}
