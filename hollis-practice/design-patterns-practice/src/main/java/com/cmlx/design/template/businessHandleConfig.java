package com.cmlx.design.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 12:17
 * @Desc -> 将AbstractBusinessHandler实现类全部注入到Spring容器中
 **/
@Configuration
public class businessHandleConfig {

    @Autowired
    List<AbstractBusinessHandler> businessHandlers;

    @Bean
    HashMap<Integer, AbstractBusinessHandler> businessHandleScript() {
        HashMap<Integer,AbstractBusinessHandler> map = new HashMap<>();
        for (AbstractBusinessHandler businessHandler : businessHandlers) {
            map.put(businessHandler.isVip(),businessHandler);
        }
        return map;
    }

}
