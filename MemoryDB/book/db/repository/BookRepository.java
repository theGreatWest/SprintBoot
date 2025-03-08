package com.example.memoryDB.book.db.repository;

import com.example.memoryDB.book.db.entity.BookEntity;
import com.example.memoryDB.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    // select * from user where score >= 사용자입력값
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    // select * from user where score >= ?? and score <= ??
    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int score);

//    @Query(
//            value = "select u from user u " + // 맨 앞의 u 는 * , user 는 테이블명, 두 번째 u 는 별칭
//                    "where u.score >= ?1 and score <= ?2", // ?1, ?2 가 사용자 입력이 들어갈 자리
//
//            // JPQL 은 또 뭐지?
//            "select u from user u " + // 맨 앞의 u 는 * , user 는 테이블명, 두 번째 u 는 별칭
//                    "where u.score >= ?1 and score <= ?2",
//            nativeQuery = true
//    )
//    List<UserEntity> score(int min, int max);
    // 복잡한 쿼리문을 사용해야 할 때
    @Query(
            value = "select u from user u " +
                    "where u.score >= :minValue and score <= :maxValue", // (:) named parameter 를 지정해주는 방법
            nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value = "minValue") int min, // 이름 지어주기
            @Param(value = "maxValue") int max
    );
}
