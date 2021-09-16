package com.cmlx.netty.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CMLX
 * @Date -> 2021/8/27 12:07
 * @Desc ->
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/test")
    public String testReceiveParameter(DemoModel model) {
        for (Long uid : model.getUids()) {
            System.out.println(uid);
        }
        return "success";
    }



}
