package com.cmlx.design.create.builder;

/**
 * @Author CMLX
 * @Date -> 2021/6/3 15:20
 * @Desc ->
 **/
public class Test {

    public static void main(String[] args) {
        Director director = new Director();
        Builder commonRoleBuilder = new CommonRoleBuilder();
        director.construct(commonRoleBuilder);
        Role result = commonRoleBuilder.getResult();
        System.out.println(result);
    }

}
