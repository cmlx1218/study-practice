package com.cmlx.design.template;

import org.springframework.stereotype.Component;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 11:34
 * @Desc -> 存钱实现类
 **/
@Component
public class SaveMoneyHandler extends AbstractBusinessHandler{
    @Override
    public int isVip() {
        return 1;
    }

    @Override
    public void handler() {
        System.out.println("save money $100");
    }

    public static void main(String[] args) {
        SaveMoneyHandler saveMoneyHandler = new SaveMoneyHandler();
        saveMoneyHandler.execute();
    }
}
