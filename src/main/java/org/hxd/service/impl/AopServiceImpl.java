package org.hxd.service.impl;

import org.hxd.service.AopService;
import org.springframework.stereotype.Service;

@Service
public class AopServiceImpl implements AopService {

    @Override
    public void aopAdvice() {
        System.out.println("我是一个业务方法");
    }
}
