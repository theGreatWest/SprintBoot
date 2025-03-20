package com.example.filter.controller;

import com.example.filter.interceptor.OpenApi;
import com.example.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @OpenApi // Open API annotation(우리가 직접 만든 것)
    @PostMapping("")
    public UserRequest register(
            @RequestBody UserRequest userRequest
//            HttpEntity http
    ) {
        log.info("{}",userRequest);
        // 잘못 보냈을 때, 제대로 mapping 되지 않는 현상 발생
        // 클라이언트가 보낸 데이터가 올바른지 확인하는 방법이 필요

        // HttpEntity 를 이용하면 어떤 형식으로 보냈는지 확인 가능
//        log.info("{}", http.getBody());

        return userRequest;
    }

    @GetMapping("/hello") // Open API annotation(우리가 직접 만든 것) 안 단 메서드
    public void hello(){
        log.info("hello~");
    }
}
