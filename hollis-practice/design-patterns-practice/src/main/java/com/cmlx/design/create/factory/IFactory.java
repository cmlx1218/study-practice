package com.cmlx.design.create.factory;

import com.cmlx.design.create.simplefactory.product.Operator;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 15:17
 * @Desc ->
 **/
public interface IFactory {

    Operator createOperator();

}
