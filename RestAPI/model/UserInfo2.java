package com.example.rest_api.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserInfo2 {
    private String name;
    private String phoneNumber;
    private Integer age; // 값이 없으면 null 이어야 하는데 int 로 선언하면 0이 default 로 들어가니까 이렇게 선언
    private String email;
    private Boolean isKorean; // int 대신 Integer 로 선언하는 것과 같은 이유로 Boolean 선언
    // set 메서드를 보면 그냥 setKorean() 인 것을 확인할 수 있음
    // 맨 앞이 is 로 시작하는 boolean 형 변수는 아래의 두 가지 방식으로 해결 가능
    // 1. 요청 시 그냥 korean = true 로 요청
    // 2. boolean 대신 Boolean 으로 변수 선언
}
