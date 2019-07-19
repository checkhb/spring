package com.fsl.springbootjwt.controller;

import com.fsl.springbootjwt.util.ServiceResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sj2
 * 注意这个统一异常处理器只对认证过的用户调用接口中的异常有作用，对AuthenticationException没有用
 */
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 捕捉shiro的异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ServiceResult handle401(ShiroException e) {
        return ServiceResult.failure("400","shiro的异常");
    }

    /**
     * 捕捉UnauthorizedException
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ServiceResult handle401() {
        return ServiceResult.failure("400","UnauthorizedException");
    }


    /**
     * 捕捉其他所有异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceResult globalException(HttpServletRequest request, Throwable ex) {
        return ServiceResult.failure("400","其他异常");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}

