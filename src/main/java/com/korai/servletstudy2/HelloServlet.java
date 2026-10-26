package com.korai.servletstudy2;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String[] names = {"일일일", "이이이"};

        // Hello
        PrintWriter out = response.getWriter();
        out.println("""
                <html>
                    <head>
                        <title>탭제목</title>
                    </head>
                    <body>
                        <h1>일일일</h1>
                        <h1>이이이</h1>
                    </body>
                </html>""");
    }

    public void destroy() {
    }
}