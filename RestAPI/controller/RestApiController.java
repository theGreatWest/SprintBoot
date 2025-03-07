package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

// 진입점이 어떠한 주소를 가지는지 작성해야 함
@RestController // Rest API 를 처리하는 컨트롤러 지정
@RequestMapping("/api") // 어떠한 주소를 받겠다고 지정하는 것
// 주소 중에 api 로 시작하는 것은 이쪽에서 받겠다는 뜻
public class RestApiController {

    @GetMapping(path = "/hello") // class 주소(/api) 중에서도 어떠한 값(/hello)을 처리하겠다.
    public String hello(){
        // 홈페이지(http://localhost:8080/api/hello)에 해당 문자열이 반환되어 나타난다.

        String str = "Hello Spring Boot";
        String html = "<html> <body> <h1>Hello Spring Boot</h1> </body> </html>";

        return html;
    }

    @GetMapping(path = "/echo/{message}")
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable String message
    ){
//        System.out.println("message = " + message);

        // TODO 대문자로 변환해서 return
        StringBuilder sb = new StringBuilder();
        for(char c : msg.toCharArray()){
            sb.append(Character.toUpperCase(c));
        }

        return sb.toString();

//        return message;
    }

    @GetMapping(path = "/booleanValue/{value}")
    public boolean blValue(
            @PathVariable(name="value") String v
    ){
        // TODO boolean, integer 형태로 파라미터 받아보기
        System.out.println(v);
        return v.equalsIgnoreCase("true") || v.equalsIgnoreCase("1");
    }

    @GetMapping(path = "/filtering/{message}/age/{age}/is-man/{isMan}")
    public String filtering(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("msg = " + msg);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);

        return msg;
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println("category = " + category);
        System.out.println("issuedYear = " + issuedYear);
        System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issuedDay = " + issuedDay);
    }
    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book2")
    public void queryParamDTO(
            BookQueryParam bookQueryParam
    ){
        System.out.println("bookQueryParam = " + bookQueryParam);
    }
}
