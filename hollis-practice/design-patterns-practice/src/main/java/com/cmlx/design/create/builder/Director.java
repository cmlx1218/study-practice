package com.cmlx.design.create.builder;

/**
 * @Author CMLX
 * @Date -> 2021/6/3 15:19
 * @Desc -> 指挥者
 **/
public class Director {

    public void construct(Builder builder) {
        builder.buildBody();
        builder.buildHead();
        builder.buildFace();
        builder.buildHp();
        builder.buildMp();
        builder.buildSp();
    }

}
