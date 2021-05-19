package com.cmlx.design.abstractfactory.factory.impl;

import com.cmlx.design.abstractfactory.factory.CarFactory;
import com.cmlx.design.abstractfactory.product.BenzCar;
import com.cmlx.design.abstractfactory.product.TeslaCar;
import com.cmlx.design.abstractfactory.product.impl.BenzSportCar;
import com.cmlx.design.abstractfactory.product.impl.TeslaSportCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:38
 * @Desc ->
 **/
public class SportCarFactory implements CarFactory {
    @Override
    public BenzCar getBenzCar() {
        return new BenzSportCar();
    }

    @Override
    public TeslaCar getTeslaCar() {
        return new TeslaSportCar();
    }
}
