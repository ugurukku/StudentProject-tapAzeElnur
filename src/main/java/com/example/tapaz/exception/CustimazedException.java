package com.example.tapaz.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j

public class CustimazedException extends ResponseEntityExceptionHandler{


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptionn(Exception ex, WebRequest request) throws Exception {
        ExceptionDetails exceptionDetails=new ExceptionDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);
    }
}
