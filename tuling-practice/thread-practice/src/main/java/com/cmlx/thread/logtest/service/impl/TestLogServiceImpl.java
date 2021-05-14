package com.cmlx.thread.logtest.service.impl;

import com.cmlx.thread.logtest.bean.TestLogBean;
import com.cmlx.thread.logtest.service.ITestLogService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author CMLX
 * @Date -> 2021/5/14 15:29
 * @Desc ->
 **/
@Component
public class TestLogServiceImpl implements ITestLogService {

    @Override
    public void batchInsert(List<TestLogBean> list) {
        //TODO 插入日志数据到数据库
        System.out.println("插入日志数据到数据库");
    }
}
