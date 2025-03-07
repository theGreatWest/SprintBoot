package com.example.memoryDB.db;

import java.util.List;
import java.util.Optional;

// 저장소에 대한 인터페이스
// 데이터의 자료형과 고유 아이디가 필요하다.

// interface : 클래스가 따라야 하는 규칙 정의

// extends : 부모의 기능을 그대로 물려받고, 기능을 확장할 때 사용
// 클래스에서는 단일 상속만 가능
// 인터페이스에서는 다중 상속 가능

public interface DataRepository<T, ID> extends Repository<T, ID> {
    // create(값이 없다면) & update(값이 있다면)
    public T save(T data);

    // read
    public Optional<T> findById(ID id);
    // 데이터가 있을 수도 있고, 없을 수도 있기 때문에 Optional 사용

    public List<T> findAll();

    // delete
    public void delete(ID id);
}
