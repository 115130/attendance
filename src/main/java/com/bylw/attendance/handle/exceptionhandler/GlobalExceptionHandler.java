package com.bylw.attendance.handle.exceptionhandler;


import com.bylw.attendance.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public Response error(SQLIntegrityConstraintViolationException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return Response.error().message("输入的数据和已有的重复了");
    }

    @ExceptionHandler(TestException.class)
    @ResponseBody
    public Response test(TestException e){
        e.printStackTrace();
        log.error(e.getMsg());
        return Response.error().code(e.getCode()).message(e.getMsg());
    }

}
