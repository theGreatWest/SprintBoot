package com.example.filter.aop;

import com.example.filter.model.UserRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component // filter 에서 @Component 를 주석 처리하니까 동작하네..? 흠...
public class TimerAop {

    @Pointcut(value = "within(com.example.filter.controller.UserApiController)")
    public void timerPointCut(){}

    @Before(value = "timerPointCut()") // 메서드가 실행 전
    public void before(JoinPoint joinPoint){
        System.out.println("before");
    }

////////////////////////////////

    @After(value = "timerPointCut()") // 메서드가 끝난 후(예외가 발생해도 실행 됨)
    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }

////////////////////////////////

    @AfterReturning(value = "timerPointCut()", returning = "result") // 메소드 호출 성공 시(Not Throws)
    public void afterReturning(JoinPoint joinPoint, Object result){ // result : 결과 값을 받을 수 있다.
        System.out.println("after returning");
    }

////////////////////////////////

    @AfterThrowing(value = "timerPointCut()", throwing = "tx") // 메소드 호출 실패 예외 발생(Throws)
    public void afterThrowing(JoinPoint joinPoint, Throwable tx){ // tx : 예외 값을 받을 수 있다.
        System.out.println("after throwing");
    }

////////////////////////////////

    @Around(value = "timerPointCut()") // Before, After 모두 제어
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메소드 실행 이전");

//        joinPoint.proceed(); // 기본 동작 확인

////////////////////////////////

        // joinPoint.getArgs() : 메서드 실행 시, 사용되는 매개변수 불러오는 메서드
        Arrays.stream(joinPoint.getArgs()).forEach(
                it -> {
//                    System.out.println(it);
                    if(it instanceof UserRequest){
                        var tempUser = (UserRequest) it;
                        var phoneNumber = tempUser.getPhoneNumber().replace("-","");
                        tempUser.setPhoneNumber(phoneNumber);
                    }
                }
        );

//        joinPoint.proceed();

////////////////////////////////

        // 암/복호화 / 로깅
        var newObjs = Arrays.asList(
                new UserRequest()
        );

//        joinPoint.proceed(newObjs.toArray());

////////////////////////////////

        // 그리고, 특정 API / Service 가 느려서 시간을 찍어 확인해야 하는데, 일일이 하는 것이 손이 너무 많이 갈 때, 아래와 같이 AOP 사용하자.
        var stopWatch = new StopWatch();

        stopWatch.start();

        joinPoint.proceed(newObjs.toArray());

        stopWatch.stop();

        System.out.println("총 소요된 시간 MS = "+stopWatch.getTotalTimeMillis());

////////////////////////////////

        System.out.println("메소드 실행 이후// Around 실행 완료");
    }
}