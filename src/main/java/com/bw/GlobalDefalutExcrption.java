package com.bw;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 赵翰 on 2017/7/28.
 */
@ControllerAdvice
public class GlobalDefalutExcrption {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultException(HttpServletRequest request, Exception e){


        return "对不起，系统繁忙，请稍后再试";
    }
}
