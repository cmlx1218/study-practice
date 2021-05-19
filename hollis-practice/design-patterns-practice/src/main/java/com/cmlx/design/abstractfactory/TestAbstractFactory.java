package com.cmlx.design.abstractfactory;

import com.cmlx.design.abstractfactory.factory.impl.SportCarFactory;
import com.cmlx.design.abstractfactory.product.BenzCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:39
 * @Desc ->
 **/
public class TestAbstractFactory {

    public static void main(String[] args) {
        SportCarFactory sportCarFactory = new SportCarFactory();
        BenzCar benzCar = sportCarFactory.getBenzCar();
        benzCar.gasUp();
    }


}
