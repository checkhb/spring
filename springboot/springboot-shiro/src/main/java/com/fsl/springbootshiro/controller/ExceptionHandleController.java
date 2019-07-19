package com.fsl.springbootshiro.controller;

import com.fsl.springbootshiro.business.consts.CommonConst;
import com.fsl.springbootshiro.business.enums.ResponseStatus;
import com.fsl.springbootshiro.framework.exception.YuddException;
import com.fsl.springbootshiro.framework.object.ResponseVO;
import com.fsl.springbootshiro.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * 统一异常处理类<br>
 * 捕获程序所有异常，针对不同异常，采取不同的处理方式
 *
 * @author yudd
 * @date 2019年5月16日15:54:16
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVO handle(Throwable e) {
        if (e instanceof YuddException) {
            return ResultUtil.error(e.getMessage());
        }
        if (e instanceof UndeclaredThrowableException) {
            e = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
        }
        ResponseStatus responseStatus = ResponseStatus.getResponseStatus(e.getMessage());
        if (responseStatus != null) {
            log.error(responseStatus.getMessage());
            return ResultUtil.error(responseStatus.getCode(), responseStatus.getMessage());
        }
        e.printStackTrace(); // 打印异常栈
        return ResultUtil.error(CommonConst.DEFAULT_ERROR_CODE, ResponseStatus.ERROR.getMessage());
    }

}
