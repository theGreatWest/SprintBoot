package com.example.validation.exception;

import com.example.validation.model.PracticeAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class PracticeExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    @Order(value = 1)
    public ResponseEntity<PracticeAPI<? extends Object>> validationException(
        MethodArgumentNotValidException exception
    ){
        log.error("@Valid Error", exception);

        var errorMessageList
                = exception.getFieldErrors()
                .stream()
                .map(e -> {
                    String format = "%s : { %s } 은 %s";
                    String message = String.format(format,
                            e.getField(),
                            e.getRejectedValue(),
                            e.getDefaultMessage()
                    );

                    return message;
                }).toList();

        var error = PracticeAPI.Error.builder()
                .errorMessages(errorMessageList)
                .build();

        var errorResponse = PracticeAPI.builder()
                .error(error)
                .resultCode(HttpStatus.BAD_REQUEST.value())
                .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}
