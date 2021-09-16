package com.cmlx.design.structure.decorator;

/**
 * @Author CMLX
 * @Date -> 2021/9/16 15:52
 * @Desc -> ConcreteComponent
 **/
public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的" + name);
    }

}
