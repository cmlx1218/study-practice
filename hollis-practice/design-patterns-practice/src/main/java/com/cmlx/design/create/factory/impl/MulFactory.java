package com.cmlx.design.create.factory.impl;

import com.cmlx.design.create.factory.IFactory;
import com.cmlx.design.create.simplefactory.product.Operator;
import com.cmlx.design.create.simplefactory.product.OperatorMul;

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
