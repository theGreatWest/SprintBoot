package com.example.jpa.user.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user") // user 테이블과 mapping 시키겠다 선언
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 아이디가 어떤식으로 생성될거냐? -> MySQL은 auto increment, auto generate 되는 값들의 어노테이션을 이렇게 잡아줘야 함
    private Long id; // Primary Key 이기 때문에 특별한 어노테이션을 붙여줘야 함

    private String name;
    private Integer age;
    private String email;
}
