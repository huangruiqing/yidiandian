package com.example.springsecurity.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandlerAdvice
 * @Description 访问发生错误时，跳转到系统统一异常处理页面
 * @Author huangrq
 * @Date 2019/3/8 16:19
 */
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)//表示捕捉到所有的异常，你也可以捕捉一个你自定义的异常
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

}
