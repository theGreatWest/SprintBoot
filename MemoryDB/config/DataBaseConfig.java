package com.example.memoryDB.config;

import com.example.memoryDB.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정임을 알려주는 어노테이션
// 스프링부트가 실행될 때 미리 객체를 만들고 주입해 주는 것
public class DataBaseConfig {
    @Bean // UserRepository 가 우리가 직접 만들 것이기 때문에 Bean 으로 설정해 줘야 한다.
    public UserRepository userRepository(){
        return new UserRepository();
    }
}
