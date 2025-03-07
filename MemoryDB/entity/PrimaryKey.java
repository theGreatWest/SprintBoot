package com.example.memoryDB.entity;

// 데이터를 정의
// id에 해당
// 모든 Entity 마다 get, set 메서드를 부여하는 것은 비효율적! 통일한다.
public interface PrimaryKey {
    void setId(Long id);

    Long getId();
}
