package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public UserRegisterRequest register(
            @Valid // 꼭 붙여줘야 적용된다.
            @RequestBody UserRegisterRequest userRegisterRequest
    ) {
        log.info("init : {}", userRegisterRequest);

        return userRegisterRequest;
    }

    @PostMapping("/errorMsg")
    // 어떤 타입인지 모르겠지만, Object 를 상속받은 요소를 반환한다.
    // 자바의 모든 클래스는 Object 를 상속받기 때문에 그냥 <?> 이렇게 써도 된다.
    public Api<UserRegisterRequest> register1(
            @Valid @RequestBody Api<UserRegisterRequest> api
    ){
        log.info("init : {}", api);

        var body = api.getData();
        Api<UserRegisterRequest> response = Api
                .<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;
    }
}
