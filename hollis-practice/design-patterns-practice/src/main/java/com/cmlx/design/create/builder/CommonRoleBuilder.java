package com.cmlx.design.create.builder;

/**
 * @Author CMLX
 * @Date -> 2021/6/3 15:13
 * @Desc -> 具体建造者
 **/
public class CommonRoleBuilder extends Builder {
    @Override
    public void buildHead() {
        role.setHead("common head");
    }

    @Override
    public void buildFace() {
        role.setFace("Common face");
    }

    @Override
    public void buildBody() {
        role.setBody("Common body");
    }

    @Override
    public void buildHp() {
        role.setHp(100d);
    }

    @Override
    public void buildSp() {
        role.setSp(100d);
    }

    @Override
    public void buildMp() {
        role.setMp(100d);
    }

    @Override
    public Role getResult() {
        return role;
    }
}
