package com.cmlx.design.create.simplefactory.product;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 14:47
 * @Desc ->
 **/
public class OperatorDiv extends Operator {
    @Override
    public double getResult() {
        if (getValue2() != 0) {
            return getValue1() / getValue2();
        }
        throw new IllegalArgumentException("除数不能为零");
    }
}
