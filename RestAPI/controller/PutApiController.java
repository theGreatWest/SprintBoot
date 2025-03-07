package com.example.rest_api.controller;

import com.example.rest_api.model.UserInfo2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 로그팩 관련된 어노테이션

@RestController
@RequestMapping("/api")
public class PutApiController {

    // http://localhost:8080/api/put
    @PutMapping("/put")
    public void put(
            @RequestBody
            UserInfo2 userInfo2
    ){
        log.info("Request : {}", userInfo2);
    }
}
