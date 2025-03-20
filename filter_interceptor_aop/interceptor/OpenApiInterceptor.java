package com.example.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class OpenApiInterceptor implements HandlerInterceptor {
    // Interceptor 를 사용하기 위해선 별도의 config 를 추가해야 한다.

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // true : 컨트롤러에 해당 request 전달
        // false : 컨트롤러에 해당 request 전달하지 X

        log.info("pre handler");

        // 특정 어노테이션을 가지고 있을 때만 통과하게 만들기
        var handlerMethod = (HandlerMethod) handler;

        // 컨트롤러나 메서드에 OpenApi 어노테이션이 붙어있는지 확인

        // 메서드에 달려있는지 확인
        // 있으면 not null, 없으면 null
        var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class);

        if(methodLevel!=null){
            return true;
        }

        // 클래스에 달려있는지 확인
        // 있으면
        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class);

        if(classLevel != null){
            return true;
        }

        log.info("해당 주소는 open api 가 아니기 때문에 요청 값을 전달하지 않습니다. {}", request.getRequestURI());
        return false;

        // true : 컨트롤러에 전달
        // false : 컨트롤러에 전달하지 X
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("post handler");
//        사용하지 않을 것 : model & view 를 아직 배우지 않아서
//        view 가 연결 됐을 때 사용되는 부분
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("after completion");
//        사용하지 않을 것
//        완료됐을 때 사용되는 부분( 어떤 예외가 발생했고, 어떤 handler 가 작동했는지 등 정보 )
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
