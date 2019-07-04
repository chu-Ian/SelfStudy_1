package com.tensquare.qa.controller;

import constants.StatusCode;
import dto.ResultDTO;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Log4j2
public class QaExceptionHandler {

    public ResultDTO errotHandler(Throwable e) {
       log.info("控制层请求异常：\n");
       e.printStackTrace();

       return new ResultDTO(false, StatusCode.ERROR, e.getMessage());
    }
}
