package com.cmlx.design.create.simplefactory;

import com.cmlx.design.create.simplefactory.product.OperatorAdd;
import com.cmlx.design.create.simplefactory.factory.OperatorFactory;
import com.cmlx.design.create.simplefactory.product.Operator;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 14:49
 * @Desc ->
 **/
public class SimpleFactoryTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 测试解耦实现方案
        OperatorAdd operatorAdd = new OperatorAdd();
        operatorAdd.setValue1(11);
        operatorAdd.setValue2(22);
        double result = operatorAdd.getResult();
        System.out.println(result);

        // 测试工厂模式方案
        Operator operator = OperatorFactory.createOperator("OperatorAdd");
        operator.setValue1(123);
        operator.setValue2(111);
        double result1 = operator.getResult();
        System.out.println(result1);
    }


}
