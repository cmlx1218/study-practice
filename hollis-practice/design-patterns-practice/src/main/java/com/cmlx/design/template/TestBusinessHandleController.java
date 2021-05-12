package com.cmlx.design.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 12:20
 * @Desc -> 测试Controller
 **/
@RestController
public class TestBusinessHandleController {

    @Autowired
    HashMap<Integer,AbstractBusinessHandler> scrips;

    @RequestMapping("/test")
    public ModelAndView test(Integer type){
        // 根据入参不同，通过type获取对应的实现类，完成相应的逻辑
        AbstractBusinessHandler abstractBusinessHandler = scrips.get(type);
        abstractBusinessHandler.execute();
        return null;
    }

}
