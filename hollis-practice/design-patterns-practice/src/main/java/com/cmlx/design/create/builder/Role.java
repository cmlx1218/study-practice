package com.cmlx.design.create.builder;

import lombok.Data;

/**
 * @Author CMLX
 * @Date -> 2021/6/3 15:11
 * @Desc -> 产品角色
 **/
@Data
public class Role {

    private String head; //头部
    private String face; //脸部（脸部依赖于头部）
    private String body; //身体
    private Double hp;   //生命值
    private Double sp;   //能量值
    private Double mp;   //魔法值

}
