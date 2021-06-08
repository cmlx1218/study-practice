package com.cmlx.design.create.abstractfactory.factory.impl;

import com.cmlx.design.create.abstractfactory.factory.CarFactory;
import com.cmlx.design.create.abstractfactory.product.BenzCar;
import com.cmlx.design.create.abstractfactory.product.TeslaCar;
import com.cmlx.design.create.abstractfactory.product.impl.BenzBusinessCar;
import com.cmlx.design.create.abstractfactory.product.impl.TeslaBusinessCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:39
 * @Desc ->
 **/
public class BusinessCarFactory implements CarFactory {
    @Override
    public BenzCar getBenzCar() {
        return new BenzBusinessCar();
    }

    @Override
    public TeslaCar getTeslaCar() {
        return new TeslaBusinessCar();
    }
}
