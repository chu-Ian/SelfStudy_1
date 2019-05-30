package com.tensquare.aritcle.controller.common;

import constants.StatusCode;
import dto.ResultDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class ArticleExceptionHandler {

    @ExceptionHandler
    public ResultDTO errorHandler(Throwable e) {
        log.info("控制层请求异常：\n");
        e.printStackTrace();

        return new ResultDTO(false, StatusCode.ERROR, e.getMessage());
    }
}
