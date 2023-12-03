package com.lhc.config;

import com.lhc.utils.Result;
import com.lhc.utils.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice{
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public <T> Result<T> handler(ServiceException e) {
        return new Result<>(e.getCode(), e.getMessage());
    }
}
