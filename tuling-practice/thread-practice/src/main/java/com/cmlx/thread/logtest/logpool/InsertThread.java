package com.cmlx.thread.logtest.logpool;

import com.cmlx.thread.logtest.bean.TestLogBean;
import com.cmlx.thread.logtest.service.ITestLogService;

import java.util.List;

/**
 * @Author CMLX
 * @Date -> 2021/5/14 15:27
 * @Desc -> 日志批量插入 的工作线程
 **/
public class InsertThread implements Runnable{

    private ITestLogService iTestLogService;

    private List<TestLogBean> list;

    public InsertThread(ITestLogService iTestLogService,List<TestLogBean> list) {
        this.iTestLogService = iTestLogService;
        this.list = list;
    }

    @Override
    public void run() {
        iTestLogService.batchInsert(list);
        // GC
        list = null;
    }
}
