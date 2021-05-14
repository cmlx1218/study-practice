package com.cmlx.thread.logtest.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @Author CMLX
 * @Date -> 2021/5/14 15:07
 * @Desc -> 测试日志
 **/
@Data
@ToString
public class TestLogBean {

    private int id;

    private String logContent;

    private String createts;

}
