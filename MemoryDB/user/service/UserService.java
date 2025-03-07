package com.example.memoryDB.user.service;

import com.example.memoryDB.user.db.UserRepository;
import com.example.memoryDB.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

@RequiredArgsConstructor
public class UserService {

    // Config 에 @Bean 을 해주면 아무것도 안 해줘도 됨
    // 그러나, @Bean 을 사용하지 않는다면
    // @Autowired 를 위에다 붙여줘야 된다.
    private final UserRepository userRepository;

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public UserEntity findById(Long id){
        return userRepository.findById(id).get();
    }

    public List<UserEntity> over70(int score){
        return userRepository.findAllScoreGreaterThan(score);
    }
}
