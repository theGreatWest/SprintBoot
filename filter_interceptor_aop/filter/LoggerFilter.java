package com.example.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
//@Component // 해당 클래스를 빈으로 등록하겠다 선언
// AOP 실습할 동안 잠식 주석 처리
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("진입 전");

        // ContentCaching-Wrapper : 읽은 내용을 캐시에 저장 => 한 번 더 읽을 수 있다.
        var request = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        var response = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        filterChain.doFilter(request, response);

        // 여기서 캐시에 있는 데이터를 사용했기 때문에, 이 코드 이후엔 캐시에 데이터가 남아있지 않다.
        var requestJson = new String(request.getContentAsByteArray());
        log.info("requestJson: {}", requestJson);

        var responseJson = new String(response.getContentAsByteArray());
        log.info("responseJson: {}", responseJson);

        // 따라서, copy 해놨던 내용(캐시)을 response 에 다시 한 번 더 덮어씌우는 작업이 필요하다.
        // 얘를 반드시 호출해 줘야 response 값이 비어있지 않은 상태로 반환된다.
        response.copyBodyToResponse();

        log.info("필터링 완료");
    }
}
