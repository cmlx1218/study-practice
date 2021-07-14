package com.cmlx.netty.lf.test;

import lombok.Builder;
import lombok.Data;

/**
 * @Author CMLX
 * @Date -> 2021/7/14 18:15
 * @Desc ->
 **/
@Data
@Builder
public class Group {

    private String id;
    private String name;
    private User user;

}
