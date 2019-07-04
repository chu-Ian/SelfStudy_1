package com.tensquare.spit.web.common;

import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpitExceptionHandler {

    @ExceptionHandler
    public ResultDTO errorHandler(Throwable e) {
        System.out.println("发生异常");
        e.printStackTrace();

        return new ResultDTO(false, StatusCode.ERROR, e.getMessage());
    }

}
