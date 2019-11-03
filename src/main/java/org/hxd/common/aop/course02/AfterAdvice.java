package org.hxd.common.aop.course02;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AfterAdvice implements AfterReturningAdvice {

    /**
     * 各参数的意义
     * @param o 方法的返回值
     * @param method 目标方法
     * @param objects 目标方法的参数
     * @param o1 目标对象，调用目标方法的对象
     * @throws Throwable 抛出异常
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("afterAdvice");
    }
}
