package com.cmlx.design.create.factory;

import com.cmlx.design.create.factory.impl.AddFactory;
import com.cmlx.design.create.simplefactory.product.Operator;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 15:20
 * @Desc ->
 **/
public class TestFactory {

    public static void main(String[] args) {
        AddFactory addFactory = new AddFactory();
        Operator operator = addFactory.createOperator();
        operator.setValue1(11);
        operator.setValue2(22);
        double result = operator.getResult();
        System.out.println(result);
    }

}
