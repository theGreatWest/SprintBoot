package com.example.exception.controller;

import com.example.exception.model.Api;
import com.example.exception.model.UserResponse;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("12")
                    .age(9)
                    .name("홍길동")
                    .build()
            ,UserResponse.builder()
                    .id("13")
                    .age(23)
                    .name("홍길자")
                    .build()
    );

    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ){
        if(true){
            throw new NoSuchElementException("hi");
        }

        var user = userList.stream() // var 가 아닌 UserResponse 로 하면 에러( 반환 값이 Optional 이기 때문에 )
                .filter(
                        o -> o.getId().equalsIgnoreCase(userId)
                )
                .findFirst()
//                .isPresent() // 값이 있는지 체크
                .get(); // 값이 null 일 수 있도록 설정

        Api<UserResponse> response = Api
                .<UserResponse>builder()
                .data(user)
                .resultCode(Integer.toString(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .build();

        return response;
    }
}
