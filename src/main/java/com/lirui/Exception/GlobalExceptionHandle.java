package com.lirui.Exception;

import com.lirui.Pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("出错了",e);
        return Result.error("操作失败,请联系管理员!");
    }
    @ExceptionHandler
    public Result handleDuplicateException(DuplicateKeyException e){
        log.error("Key重复",e);
        String m = e.getMessage();
        int i = m.indexOf("Duplicate entry");
        String ex = m.substring(i).split(" ")[2];
        return Result.error(ex +"已存在!");
    }
}
