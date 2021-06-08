package com.cmlx.design.create.abstractfactory.product.impl;

import com.cmlx.design.create.abstractfactory.product.TeslaCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:34
 * @Desc ->
 **/
public class TeslaSportCar implements TeslaCar {
    @Override
    public void charge() {
        System.out.println("给特斯拉跑车充电");
    }
}
