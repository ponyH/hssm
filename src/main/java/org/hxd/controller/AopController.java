package org.hxd.controller;

import org.hxd.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AopController {

    @Autowired
    private AopService aopService;

    /**
     * 前置通知、后置通知测试、返回通知、异常通知、环绕通知(接口方式实现)
     */
    @RequestMapping("/aop")
    public void aopAdvice(){
        aopService.aopAdvice();
    }

    @RequestMapping("/annotationAop")
    public void annotationAdvice(){
        aopService.annotationAdvice();
    }
}
