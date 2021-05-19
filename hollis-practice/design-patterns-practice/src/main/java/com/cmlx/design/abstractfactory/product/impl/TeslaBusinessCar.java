package com.cmlx.design.abstractfactory.product.impl;

import com.cmlx.design.abstractfactory.product.TeslaCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:35
 * @Desc ->
 **/
public class TeslaBusinessCar implements TeslaCar {
    @Override
    public void charge() {
        System.out.println("给特斯拉商务车充电");
    }
}
