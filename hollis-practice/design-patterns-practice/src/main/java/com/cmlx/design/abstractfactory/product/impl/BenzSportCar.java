package com.cmlx.design.abstractfactory.product.impl;

import com.cmlx.design.abstractfactory.product.BenzCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:32
 * @Desc ->
 **/
public class BenzSportCar implements BenzCar {
    @Override
    public void gasUp() {
        System.out.println("给奔驰跑车加汽油");
    }
}
