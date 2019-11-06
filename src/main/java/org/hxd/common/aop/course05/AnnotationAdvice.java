package org.hxd.common.aop.course05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAdvice {

    /**
     * 注解代表的是业务方法，被注解的方法是具体的通知，二@Before代表前置，在业务方法执行之前，先执行通知
     */
    @Before("execution(* org.hxd.service.impl.AopServiceImpl.annotationAdvice(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        // 目标对象
        Object target = joinPoint.getTarget();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("注解方式实现的aop" + target);
    }

    /**
     * 返回通知，将目标方法的返回值存放在Object returningValue之中，注意不要修改变量名
     * 若异常unbound pointcut parameter 'returningValue'出现，需要coder编程式告诉Spring返回值使用什么接收
     * 注意参数不能多，也不能少，也不要随便修改参数名
     */
    @AfterReturning(pointcut = "execution(* org.hxd.service.impl.AopServiceImpl.annotationAdvice(..))", returning = "returningValue")
    public void afterReturningAdvice(JoinPoint joinPoint, Object returningValue){
        System.out.println("返回通知，目标方法的返回值是：" + returningValue);
    }

    /**
     * 注解式异常通知
     * 获取异常信息，需要coder告诉Spring异常信息用哪个异常对象接收
     */
    @AfterThrowing(pointcut = "execution(* org.hxd.service.impl.AopServiceImpl.annotationAdvice(..))", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex){
        System.out.println("异常通知，异常信息是：" + ex.getMessage());
    }

    /**
     * 最终通知
     */
    @After("execution(* org.hxd.service.impl.AopServiceImpl.annotationAdvice(..))")
    public void AfterAdvice(JoinPoint joinPoint){
        System.out.println("最终通知");
    }

    /**
     * 注解式环绕通知
     */
    @Around("execution(* org.hxd.service.impl.AopServiceImpl.annotationAdvice(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp){

        // 前置通知
        Object returningValue = null;
        System.out.println("环绕通知的前置通知");
        try {
            returningValue = pjp.proceed();
            // 正常返回通知
            System.out.println("环绕通知的返回通知，目标方法的返回值是：" + returningValue);
        } catch (Throwable throwable){
            // 异常通知
            System.out.println("环绕通知的异常通知，异常信息是：" + throwable.getMessage());
        } finally {
            // 最终通知
            System.out.println("环绕通知的最终通知");
        }
        return returningValue;
    }
}
