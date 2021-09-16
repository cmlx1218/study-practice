package com.cmlx.design.structure.proxy;

/**
 * @Author CMLX
 * @Date -> 2021/9/16 17:27
 * @Desc ->
 **/
public class Proxy implements GiveGift {

    private Pursuit gg;

    public Proxy(SchoolGirl mm) {
        gg = new Pursuit(mm);
    }

    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void giveFollowers() {
        gg.giveFollowers();
    }

    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }
}
