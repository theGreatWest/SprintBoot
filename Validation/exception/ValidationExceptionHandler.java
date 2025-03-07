//package com.example.validation.exception;
//
//import com.example.validation.model.Api;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.stream.Collectors;
//
//@Slf4j
//@RestControllerAdvice
//public class ValidationExceptionHandler {
//
//    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//    public ResponseEntity<Api<? extends Object>> validationException(
//        MethodArgumentNotValidException exception
//    ){
//        log.error("", exception);
//
//            var errorMessageList = exception
//                    .getFieldErrors() // 에러가 발생한 필드들 가져오기
//                    .stream()
//                    .map(e -> {
//                        var format = "%s : { %s } 은 %s";
//                        var msg = String.format(format, e.getField(), e.getRejectedValue(), e.getDefaultMessage());
//                        return msg;
//                    }).collect(Collectors.toList());
//
//            var error = Api.Error
//                    .builder()
//                    .errorMessage(errorMessageList)
//                    .build();
//
//            var errorResponse = Api.builder()
//                    .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
//                    .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase()) // 이유
//                    .error(error)
//                    .build();
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//}
