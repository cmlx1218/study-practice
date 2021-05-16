package com.cmlx.thread.spring.controller;


import com.cmlx.thread.spring.service.IAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class TestAsyncController {

    @Autowired
    private IAsyncService iAsyncService;

    @RequestMapping("/testAsync")
    public String test(){
        iAsyncService.executeAsync();
        return "";
    }

}
