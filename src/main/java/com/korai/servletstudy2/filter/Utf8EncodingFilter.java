package com.korai.servletstudy2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/api/*") // api를 지나는 모든 파일은 이 filter를 거쳐서 간다.
public class Utf8EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("1");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8"); // 인코딩은 전처리
        chain.doFilter(request,response); // 호출해야만 servlet 실행
        System.out.println("3");
    }
}
