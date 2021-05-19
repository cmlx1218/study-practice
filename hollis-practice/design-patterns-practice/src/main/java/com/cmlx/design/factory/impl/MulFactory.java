package com.cmlx.design.factory.impl;

import com.cmlx.design.factory.IFactory;
import com.cmlx.design.simplefactory.product.Operator;
import com.cmlx.design.simplefactory.product.OperatorAdd;
import com.cmlx.design.simplefactory.product.OperatorMul;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 15:18
 * @Desc ->
 **/
public class MulFactory implements IFactory {
    @Override
    public Operator createOperator() {
        return new OperatorMul();
    }
}
