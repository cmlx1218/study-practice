package com.cmlx.design.create.abstractfactory.factory;

import com.cmlx.design.create.abstractfactory.product.BenzCar;
import com.cmlx.design.create.abstractfactory.product.TeslaCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:36
 * @Desc ->
 **/
public interface CarFactory {

    BenzCar getBenzCar();

    TeslaCar getTeslaCar();

}
