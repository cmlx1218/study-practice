package com.cmlx.thread.parallel.service.impl;

import com.cmlx.thread.parallel.service.IMainMethodService;
import com.cmlx.thread.parallel.service.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author CMLX
 * @Date -> 2021/5/15 17:40
 * @Desc ->
 **/
@Service
public class SerialServiceImpl implements ISerialService {

    @Autowired
    private IMainMethodService iMainMethodService;

    @Override
    public void testSerial() {
        iMainMethodService.add();
        iMainMethodService.sub();
        iMainMethodService.mul();
        iMainMethodService.div();
    }
}
