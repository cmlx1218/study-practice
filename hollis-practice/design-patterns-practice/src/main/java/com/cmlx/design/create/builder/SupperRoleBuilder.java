package com.cmlx.design.create.builder;

/**
 * @Author CMLX
 * @Date -> 2021/6/3 15:15
 * @Desc -> 具体建造者
 **/
public class SupperRoleBuilder extends Builder{
    @Override
    public void buildHead() {
        role.setHead("Supper head");
    }

    @Override
    public void buildFace() {
        role.setFace("Supper face");
    }

    @Override
    public void buildBody() {
        role.setBody("Supper body");
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
