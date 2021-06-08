package com.cmlx.design.create.abstractfactory.factory.impl;

import com.cmlx.design.create.abstractfactory.factory.CarFactory;
import com.cmlx.design.create.abstractfactory.product.BenzCar;
import com.cmlx.design.create.abstractfactory.product.TeslaCar;
import com.cmlx.design.create.abstractfactory.product.impl.BenzSportCar;
import com.cmlx.design.create.abstractfactory.product.impl.TeslaSportCar;

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
