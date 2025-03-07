package com.example.memoryDB.practice.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID> {
    // create, update
    public T createUpdate(T data);

    // read
    public List<T> readAll();
    public Optional<T> read(ID id); // 값이 있을 수도 있고, 없을 수도 있기 때문에 Optional<T> 를 사용한다.
    // Optional<T> : 값이 있을 수도 있고, 없을 수도 있는 객체를 감싸는 wrapper 클래스. null 체크를 직접하지 않아도(ifPresent() 등) 안전한 코드 작성 가능

    // delete
    public void delete(ID id);
}
