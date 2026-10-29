package com.korai.servletstudy2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/api/*")
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("전처리");
        System.out.println("11");

        // 다운캐스팅하여 사용
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String method = req.getMethod();

        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type" );

        System.out.println(method);
        if ("OPTIONS".equals(method)) { // OPTIONS으로 값이 넘어 온 경우 진행은 하지 않고 상태만 반환
            resp.setStatus(200);
            return;
        }

        chain.doFilter(request, response);
        System.out.println("22");
        System.out.println("후처리");
    }
}
