package com.example.memoryDB.user.model;

import com.example.memoryDB.entity.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity { // 데이터 베이스에 저장할 값이기 때문에 상속 받는다.
    private String name;
    private Integer score;
}
