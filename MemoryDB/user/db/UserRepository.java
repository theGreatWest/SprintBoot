package com.example.memoryDB.user.db;

import com.example.memoryDB.db.SimpleDataRepository;
import com.example.memoryDB.user.model.UserEntity;

import java.util.List;

public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    public List<UserEntity> findAllScoreGreaterThan(int score){
        return this.findAll().stream()
                .filter(o -> {
                    return o.getScore() >= score;
                })
                .toList();
    }

}
