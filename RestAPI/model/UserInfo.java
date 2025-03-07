package com.example.rest_api.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
// 요청이 snake case 로 들어와도 자동적으로 매핑됨
public class UserInfo {
    private String name;
    private String phoneNumber;
    private int age; // json 에서 받을 경우 Integer 로 선언할 것
    // int 로 해도 깨지지 않는데 왜 그러지..
    // int 는 0으로 default 값으로 사용하기 때문에 null 을 default 값으로 갖는 Integer 를 사용하는 것이 안전
    private String email;
}
