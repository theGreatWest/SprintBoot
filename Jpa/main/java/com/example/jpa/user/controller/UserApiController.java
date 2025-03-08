package com.example.jpa.user.controller;

import com.example.jpa.user.db.UserEntity;
import com.example.jpa.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jpa")
@RequiredArgsConstructor
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/find-all")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/find-by-id")
    public Optional<UserEntity> findById(){
        return userRepository.findById(1L);
    }

    @GetMapping("/{name}")
    public void autoSave(
            @PathVariable String name
    ){
        var user = UserEntity.builder()
                .name(name)
                .build();

        userRepository.save(user);
    }
}
