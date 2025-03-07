package com.example.rest_api.controller;

import com.example.rest_api.model.UserInfo2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller // 그냥 RestController 사용 권장
// @ResponseBody 를 붙여주면 HTML 이 아닌 JSON 형태로 응답 내려간다.
//객체를 반환하는데 그냥 컨트롤러를 사용했다면, 무조건 해당 어노테이션을 붙여줘야 에러가 뜨지 않는다

//@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    // http://localhost:8080/api/v1
//    @GetMapping("")
    @RequestMapping( path ="", method = RequestMethod.GET )
    // == @GetMapping( path = ”” )
    //method 를 지정해 주지 않으면 get, post, put 모두 동작. 이것을 사용한다면 어떤 method인지 명확하게 밝혀줄 것.
    public ResponseEntity<UserInfo2> user(){
        var user = new UserInfo2();
        user.setName("홍길동");
        user.setAge(10);
        user.setEmail("hong@gmail.com");

        var response = ResponseEntity
                .status(HttpStatus.OK)
                .body(user);

        return response;
    }
}
