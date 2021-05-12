package com.cmlx.design.template;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 11:27
 * @Desc -> 模板方法设计模式的抽象类
 **/
@Component
public abstract class AbstractBusinessHandler {

    /**
     * 模板方法
     */
    public final void execute() {
        if (isVip() == 1) {
            getNumber();
        }
        handler();
        judge();
    }

    /**
     * 是否是VIP
     */
    public abstract int isVip();

    /**
     * 取号
     */
    private void getNumber() {
        Random random = new Random();
        System.out.println("rowNumber:" + random.nextInt());
    }

    /**
     * 办理
     */
    // 抽象的办理业务方法，由子类实现
    public abstract void handler();


    /**
     * 评价
     */
    private void judge() {
        System.out.println("give a judge");
    }

}
