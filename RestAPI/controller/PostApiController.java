package com.example.rest_api.controller;

import com.example.rest_api.model.BookRequest;
import com.example.rest_api.model.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // http://localhost:8080/api/post
    @PostMapping("/post")
    public String post(
            // default 가 객체로 받아야 한다.
            @RequestBody BookRequest bookRequest
    ){
        System.out.println("bookRequest = " + bookRequest);
        return bookRequest.toString();
    }

    @PostMapping("/user")
    public void postUser(
            @RequestBody UserInfo userInfo
    ){
        System.out.println("userInfo = " + userInfo);
    }

}
