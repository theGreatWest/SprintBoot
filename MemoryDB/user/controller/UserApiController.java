package com.example.memoryDB.user.controller;

import com.example.memoryDB.user.model.UserEntity;
import com.example.memoryDB.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")

@RequiredArgsConstructor // final 로 선언된 것을 생성자로 만들어 채워주는 메서드
public class UserApiController {
    private final UserService userService;

    @PutMapping("") // update, create 이기 때문에 Put Mapping 을 사용한다.
    public UserEntity create(
            @RequestBody UserEntity user // 원래는 entity 를 컨트롤러에서 바로 받으면 안 된다.
    ){
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<UserEntity> finaAll(){
        return userService.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(
            @PathVariable Long id
    ){
        userService.delete(id);
    }

    @GetMapping("/findById/id/{id}")
    public UserEntity findById(
            @PathVariable Long id
    ){
        UserEntity targetUser = userService.findById(id);
        if(targetUser==null){
            return null;
        }
        return targetUser;
    }

    @GetMapping("/quest")
    public List<UserEntity> over70(
            @RequestParam int score
    ){
        return userService.over70(score);
    }
}
