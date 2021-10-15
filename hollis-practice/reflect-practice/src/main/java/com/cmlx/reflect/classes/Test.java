package com.cmlx.reflect.classes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Author CMLX
 * @Date -> 2021/9/29 12:06
 * @Desc ->
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        // 获取一个类的Class对象
        Class<MyObject> myObject = MyObject.class;
        Class<?> aClass = Class.forName("com.cmlx.reflect.classes.MyObject");

        // 获取类名(包含包名)
        String name = aClass.getName();
        // 获取类名(不包含包名)
        String simpleName = aClass.getSimpleName();

        // 获取类的修饰符,修饰符都被包装成一个int类型的数字，这样每个修饰符都是一个位标识(flag bit)，这个位标识可以设置和清除修饰符的类型。
        int modifiers = aClass.getModifiers();
        boolean aPublic = Modifier.isPublic(modifiers);

        // 包信息
        Package aPackage = aClass.getPackage();

        // 父类
        Class<?> superclass = aClass.getSuperclass();

        // 实现的接口
        Class<?>[] interfaces = aClass.getInterfaces();

        // 构造器
        Constructor<?>[] constructors = aClass.getConstructors();

        // 方法
        Method[] methods = aClass.getMethods();

        // 变量
        Field[] fields = aClass.getFields();

        // 注解
        Annotation[] annotations = aClass.getAnnotations();

        System.out.println("success");
    }

}
