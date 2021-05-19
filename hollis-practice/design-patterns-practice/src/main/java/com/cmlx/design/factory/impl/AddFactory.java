package com.cmlx.design.factory.impl;

import com.cmlx.design.factory.IFactory;
import com.cmlx.design.simplefactory.product.Operator;
import com.cmlx.design.simplefactory.product.OperatorAdd;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 15:18
 * @Desc ->
 **/
public class AddFactory implements IFactory {
    @Override
    public Operator createOperator() {
        return new OperatorAdd();
    }
}
