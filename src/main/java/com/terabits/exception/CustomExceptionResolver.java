package com.terabits.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/15.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    /* 前端控制器DispatcherServlet在进行HandlerMapping、
     调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
     参数中的handler是最终要执行的Handler，它的真实身份是HandlerMethod
     ex就是接受到的异常信息*/
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex){
        return null;
    }
}
