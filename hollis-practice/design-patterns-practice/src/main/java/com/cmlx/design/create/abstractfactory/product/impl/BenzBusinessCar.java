package com.cmlx.design.create.abstractfactory.product.impl;

import com.cmlx.design.create.abstractfactory.product.BenzCar;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:33
 * @Desc ->
 **/
public class BenzBusinessCar implements BenzCar {
    @Override
    public void gasUp() {
        System.out.println("给奔驰商务车加汽油");
    }
}
