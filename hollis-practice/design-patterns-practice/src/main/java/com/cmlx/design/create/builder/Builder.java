package com.cmlx.design.create.builder;

import lombok.Data;

/**
 * @Author CMLX
 * @Date -> 2021/6/3 15:11
 * @Desc -> 抽象建造者
 **/
public abstract class Builder {

    Role role = new Role();

    public abstract void buildHead();

    public abstract void buildFace();

    public abstract void buildBody();

    public abstract void buildHp();

    public abstract void buildSp();

    public abstract void buildMp();

    public Role getResult() {
        return role;
    }

}
