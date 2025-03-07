package com.example.rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok 을 사용할 때 쓰는 어노테이션
// 자동으로 기본 생성자, getter/setter를 사용할 수 있음

@AllArgsConstructor // 전체 변수를 담는 생성자 생성
@NoArgsConstructor // default 생성자 생성
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;
}
