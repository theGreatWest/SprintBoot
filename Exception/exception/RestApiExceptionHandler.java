package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
@Order(1) // Global Handler 를 Max로 지정해 두었기 때문에, 그 값보다 작은 해당 핸들러는 먼저 실행된다.
// 패키지 지정 가능
// 해당 패키지 하위의 모든 클래스들에서 발생하는 예외 처리하겠다.
//@RestControllerAdvice(basePackages = "com.example.exception.controller")
//@RestControllerAdvice(basePackageClasses = {RestApiBController.class})
public class RestApiExceptionHandler {

    // 모든 예외 처리 -> 글로벌 핸들러로 이동
//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity exception(
//            Exception e // 어떤 예외가 발생했는지
//    ){
//        log.error("RestApiExceptionHandler!", e);
//
//        return ResponseEntity.status(200).build();
//        // 응답을 200으로 내렸기 때문에, 프로그램은 정상 작동한다.
//    }

    // 원하는 예외만 처리
    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundException ", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement(
            NoSuchElementException e
    ){
        log.error("NoSuchElementException", e);

        Api response = Api.builder()
                .resultCode(Integer.toString(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

}
