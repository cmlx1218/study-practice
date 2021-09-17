package com.cmlx.design.structure.facade;

/**
 * @Author CMLX
 * @Date -> 2021/9/17 17:57
 * @Desc -> 为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 **/
public class Facade {

    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    public Facade() {

        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();

    }

    public void methodA() {
        System.out.println("方法组A");
        one.methodOne();
        two.methodTwo();
        four.methodFour();
    }

    public void methodB() {
        System.out.println("方法组B");
        one.methodOne();
        four.methodFour();
    }


}
