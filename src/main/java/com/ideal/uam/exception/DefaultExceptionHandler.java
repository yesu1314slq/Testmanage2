package com.ideal.uam.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
/**
 * 类名称:DefaultExceptionHandler
 * 创建人：吕金刚 lvjghappy@163.com    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改备注：
 * @return
 **/
@ControllerAdvice
public class DefaultExceptionHandler {

    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler(value={UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e){
        System.out.println("-----------------------------------------------------");
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorInfo", e);
        mv.setViewName("unauthorized");
        return mv;
    }

}
