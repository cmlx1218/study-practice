package com.cmlx.design.factory;

import com.cmlx.design.simplefactory.product.Operator;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 15:17
 * @Desc ->
 **/
public interface IFactory {

    Operator createOperator();

}
