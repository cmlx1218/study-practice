package com.cmlx.design.create.simplefactory.product;

import lombok.Data;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 14:45
 * @Desc -> 计算基类
 **/
@Data
public abstract class Operator {

    private double value1;

    private double value2;

    public abstract double getResult();


}
