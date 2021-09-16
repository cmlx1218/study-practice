package com.cmlx.design.structure.proxy;

/**
 * @Author CMLX
 * @Date -> 2021/9/16 17:22
 * @Desc ->
 **/
public class Pursuit implements GiveGift {

    private SchoolGirl mm;

    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    @Override
    public void giveDolls() {
        System.out.println(mm.getName() + "送你洋娃娃");
    }

    @Override
    public void giveFollowers() {
        System.out.println(mm.getName() + "送你鲜花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(mm.getName() + "送你巧克力");
    }
}
