package org.hxd.common.aop.course04;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 本质是通过拦截器实现的
 */
@Component
public class AroundAdvice implements MethodInterceptor {

    /**
     * @param methodInvocation 目标对象的代理对象
     * @return 目标方法的返回值类型
     * @throws Throwable 抛出异常
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 前置通知
        System.out.println("环绕通知的前置通知");

        Object proceed = null;
        try {
            // 目标方法执行，不写就不会调用目标方法，proceed即为目标方法的返回值
            proceed = methodInvocation.proceed();
            String methodName = methodInvocation.getMethod().getName();
            Object[] args = methodInvocation.getArguments();
            Object target = methodInvocation.getThis();
            // 返回通知
            System.out.println("目标对象是："+ target + "，方法名是：" + methodName + "，参数长度：" + args.length + "，返回值是：" + proceed);
        } catch (Exception e) {
            // 异常通知
            System.out.println("环绕通知的异常通知");
        } finally {
            // 最终通知
            System.out.println("环绕通知的最终通知");
        }
        return proceed;
    }
}
