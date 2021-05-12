package com.cmlx.design.template;

import org.springframework.stereotype.Component;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 11:34
 * @Desc -> 存钱实现类
 **/
@Component
public class ShoppingHandler extends AbstractBusinessHandler{
    @Override
    public int isVip() {
        return 0;
    }

    @Override
    public void handler() {
        System.out.println("Shopping");
    }

    public static void main(String[] args) {
        ShoppingHandler shoppingHandler = new ShoppingHandler();
        shoppingHandler.execute();
    }
}
