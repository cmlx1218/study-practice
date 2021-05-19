package com.cmlx.design.simplefactory.product;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 14:47
 * @Desc ->
 **/
public class OperatorAdd extends Operator{
    @Override
    public double getResult() {
        return getValue1() + getValue2();
    }
}
