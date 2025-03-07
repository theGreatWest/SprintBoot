package com.example.rest_api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class DeleteController {
    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
    }) // 여러 주소 넣을 수 있다.
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }
}
