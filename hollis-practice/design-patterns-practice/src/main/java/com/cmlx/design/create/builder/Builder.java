package com.cmlx.design.create.builder;

/**
 * @Author CMLX
 * @Date -> 2021/6/3 15:11
 * @Desc -> 抽象建造者：建造者模式是在当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时适用的模式
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
