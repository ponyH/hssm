package org.hxd.common.aop.course03;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class ExceptionAdvice implements ThrowsAdvice {

    // 该方法要么只有一个参数，要么有四个参数，两种情况二选一
    public void afterThrowing(Method method, Object[] args, Object target, Throwable ex){
        System.out.println("异常通知，目标对象：" + target + "方法名：" + method.getName() + "参数个数是：" + args.length + "异常类型是：" + ex.getMessage());
    }

    // public void afterThrowing(Exception ex){}
}
