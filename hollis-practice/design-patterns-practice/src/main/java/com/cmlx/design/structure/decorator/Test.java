package com.cmlx.design.structure.decorator;

/**
 * @Author CMLX
 * @Date -> 2021/9/16 16:14
 * @Desc ->
 **/
public class Test {

    public static void main(String[] args) {
        Person person = new Person("强哥");
        System.out.println("第一种装扮》》》》》》》》");

        BigTrouser bigTrouser = new BigTrouser();
        TShirts tShirts = new TShirts();

        bigTrouser.Decorate(person);
        tShirts.Decorate(bigTrouser);

        tShirts.show();


        System.out.println("第二种装扮》》》》》》》》");
        tShirts.Decorate(person);
        bigTrouser.Decorate(tShirts);

        bigTrouser.show();

    }

}
