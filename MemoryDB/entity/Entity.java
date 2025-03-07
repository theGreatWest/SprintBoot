package com.example.memoryDB.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 추상 클래스
// 인터페이스만 만들면, 각 엔티티에서 get, set 메서드를 직접 구현해야 하는 불편함이 있기 때문에 추상클래스에서 기본적인 속성을 구현해 주는 것
// 다른 엔티티에서 이걸 상속받아 사용하면 자동으로 id 속성이 생기는 것!
// 중복을 방지하기 위한 방법이다.
@Data
public abstract class Entity implements PrimaryKey {
    private Long id;
}
