package com.example.memoryDB.db;

import com.example.memoryDB.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

// 추상 클래스: 얘를 상속받는 애들이 구현을 해도 되고, 안해도 되는 구조
// 파라미터를 아래와 같이 해주면 Entity 를 상속받은 애들만 들어올 수 있고, long 을 상속받은 애들만 들어올 수 있다.
abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {
    private List<T> dataList = new ArrayList<>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

// create & update
    @Override
    public T save(T data) {
        if(Objects.isNull(data)){ // data 가 null 이면 예외 던지기
            throw new RuntimeException("Data is null");
        }

        // 데이터가 이미 있는가?
        var prevData = dataList.stream()
                        .filter(o -> {
                            return o.getId().equals(data.getId());
                        })
                        .findFirst();

        if(prevData.isPresent()) { // 기존 데이터가 있는 경우 Update
            dataList.remove(prevData.get());
            dataList.add(data);
        }else{ // 기존에 데이터가 없는 경우
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return null;
    }

// read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(o -> {
                    return (o.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

// delete
    @Override
    public void delete(ID id) {
        var deleteEntity = findById(id);

        deleteEntity.ifPresent(t -> dataList.remove(t));
    }

}
