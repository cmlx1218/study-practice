package com.cmlx.design.create.classtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CMLX
 * @Date -> 2021/5/11 18:13
 * @Desc ->
 **/
@RestController
public class ClassTestController {

    @RequestMapping("/newInstance")
    public String newInstance(){

        Father father = new Father();
        return "";
    }
    @RequestMapping("/newChildrenInstance")
    public String childrenInstance(){

        Children children = new Children();
        return "";
    }
    @RequestMapping("/staticField")
    public String staticField(){

        String staticValue = Children.staticValue;
        return "";
    }

    @RequestMapping("staticMethod")
    public String staticMethod(){

        String bed = Children.bed();
        return "";
    }

    @RequestMapping("classForName")
    public String classForName() throws Exception {

        Class.forName("com.zhixie.jvmclassload.demo.Children");
        return "";
    }

}
