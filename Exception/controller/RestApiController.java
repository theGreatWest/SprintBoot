package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    // http://localhost:8080/api
    @GetMapping("")
    public void hello(){
//        throw new RuntimeException("run time exception call");
/* 실행 결과 500 error, 로그는 아래와 같다.
        java.lang.RuntimeException: run time exception call
        at com.example.exception.controller.RestApiController.hello(RestApiController.java:14)
*/
        var list = List.of("hello");
        var element = list.get(1);
        log.info("element : {}", element);
/*
실행 결과 500 error
*/
        // 이렇게 하나씩 찾아서 try-cath 처리하는 것은 비효율적
        // global 하게 처리하는 법 배움
    }
}
