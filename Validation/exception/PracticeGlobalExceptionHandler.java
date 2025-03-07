package com.example.validation.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class PracticeGlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @Order(value = Integer.MAX_VALUE)
    public ResponseEntity globalException(
        Exception exception
    ){
        log.error("Global Exception", exception);

        return ResponseEntity.status(200).build();
    }
}
