package com.ayush.School.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e){
        ModelAndView errorPage = new ModelAndView();
;        errorPage.setViewName("error");
        errorPage.addObject("errormsg", e.getMessage());
        return errorPage;
    }
}
