package com.cmlx.design.abstractfactory.factory;

import com.cmlx.design.abstractfactory.product.BenzCar;
import com.cmlx.design.abstractfactory.product.TeslaCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:36
 * @Desc ->
 **/
public interface CarFactory {

    BenzCar getBenzCar();

    TeslaCar getTeslaCar();

}
