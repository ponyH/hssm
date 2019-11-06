package org.hxd.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC中实现拦截器有两种方式
 * 1、实现HandlerInteceptor接口
 * 2、继承HandlerInteceptorAdapter类
 * 注意上述二种方式实现拦截器都必须重写其preHandle()、postHandle()、afterCompletion()方法
 * 且postHandle()和afterCompletion()都只在preHandle()返回true的情况下才会执行
 */
public class HInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理返回ModelAndView之前");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("整个请求流程都已经完成");
    }
}
