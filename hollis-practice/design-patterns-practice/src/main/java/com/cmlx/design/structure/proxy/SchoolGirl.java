package com.cmlx.design.structure.proxy;

import lombok.Data;

/**
 * @Author CMLX
 * @Date -> 2021/9/16 17:23
 * @Desc ->
 **/
@Data
public class SchoolGirl {

    private String name;

    public SchoolGirl() {
    }

    public SchoolGirl(String name) {
        this.name = name;
    }
}
