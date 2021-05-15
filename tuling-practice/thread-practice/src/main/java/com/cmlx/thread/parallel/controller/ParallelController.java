package com.cmlx.thread.parallel.controller;

import com.cmlx.thread.parallel.service.IParallelService;
import com.cmlx.thread.parallel.service.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CMLX
 * @Date -> 2021/5/15 17:35
 * @Desc -> 串行改并行运行Controller
 **/
@RequestMapping("/v1/api")
@RestController
public class ParallelController {

    @Autowired
    private ISerialService iSerialService;

    @Autowired
    private IParallelService iParallelService;

    @RequestMapping("/serial")
    public Long testSerial() {
        long startTime = System.currentTimeMillis();
        iSerialService.testSerial();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


    @RequestMapping("/parallel")
    public Long testParallel() {

        return 1000L;
    }


}
