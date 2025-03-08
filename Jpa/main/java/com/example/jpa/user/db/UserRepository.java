package com.example.jpa.user.db;

import org.springframework.data.jpa.repository.JpaRepository;

// <사용할 DTO 클래스명, AutoIncrement 지정한 PrimaryKey 자료형>
// 같은 interface 이므로 implements 가 아닌 extends 로 받아준다.
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
