package com.cmlx.design.structure.decorator;

/**
 * @Author CMLX
 * @Date -> 2021/9/16 15:53
 * @Desc -> 服饰类 (Decorator)
 **/
public class Finery extends Person{

    protected Person component;

    // 打扮
    public void Decorate(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (component != null) {
            component.show();
        }
    }

}
