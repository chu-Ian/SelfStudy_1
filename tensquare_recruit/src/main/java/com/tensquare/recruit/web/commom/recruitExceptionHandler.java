package com.tensquare.recruit.web.commom;

import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层公共异常处理类
 */
@ControllerAdvice
public class recruitExceptionHandler {

    @ExceptionHandler
    public ResultDTO ErrotHandler(Throwable e) {
        System.out.println("记录日志：发生了异常");
        e.printStackTrace();
        return new ResultDTO(false, StatusCode.ERROR, e.getMessage());
    }
}
