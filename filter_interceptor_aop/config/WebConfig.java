package com.example.filter.config;

import com.example.filter.interceptor.OpenApiInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    private OpenApiInterceptor openApiInterceptor; // Autowired 로 해줘도 되고, private final 로 해줘도 된다.

    private final OpenApiInterceptor openApiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(openApiInterceptor) // addInterceptor 를 한 순서대로 동작한다.
                // 특정 주소(패턴 주소)에만 맵핑 가능
                .addPathPatterns("/**"); // 루트 하위의 모든 주소에 맵핑하겠다
        // => 들어오는 모든 주소에 open API Interceptor 를 전부 맵핑하겠다.
    }
}
