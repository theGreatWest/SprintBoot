package com.example.memoryDB.practice.db;

import com.example.memoryDB.practice.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
@Slf4j
public abstract class SimpleDataRepository<T extends BaseEntity, ID extends Long> implements DataRepository<T, ID> {
    private List<T> dataList = new ArrayList<>();

    private static Long index = 0L;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    @Override
    public T createUpdate(T data) {
        if(Objects.isNull(data)){
            throw new RuntimeException("Data is null");
        }

        var existData = dataList.stream()
                .filter(entity -> {
                    return entity.getId().equals(data.getId());
                    // 기본 타입끼리 비교할 땐 사용하면 안 된다.
                    // 객체(Long)이기 때문에 .equals() 를 사용할 수 있는 것이다.
                })
                .findFirst();
        log.info(String.valueOf(existData.get()));

        if(existData.isPresent()){ // Optional 객체 자료형이기 때문에 가능한 조건
            dataList.remove(existData.get()); // 이미 존재하는 데이터 지우기
            dataList.add(data);
        }else{
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return null;
    }

    @Override
    public List<T> readAll() {
        return dataList.stream()
                .sorted(sort) // id 순서로 나열 후 반환
                .toList();
    }

    @Override
    public Optional<T> read(ID id) {
        return dataList.stream()
                .filter(o -> {
                    return o.getId().equals(id);
                })
                .findFirst();
    }

    @Override
    public void delete(ID id) {
        var delEntity = read(id);

        delEntity.ifPresent(t -> dataList.remove(t));
    }
}
