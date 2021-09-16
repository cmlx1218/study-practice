package com.cmlx.design.structure.proxy;

/**
 * @Author CMLX
 * @Date -> 2021/9/16 17:28
 * @Desc ->
 **/
public class Test {

    public static void main(String[] args) {
        SchoolGirl mm = new SchoolGirl("娇娇");

        Proxy proxy = new Proxy(mm);
        proxy.giveDolls();
        proxy.giveFollowers();
        proxy.giveChocolate();

    }

}
