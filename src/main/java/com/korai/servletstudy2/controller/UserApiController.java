package com.korai.servletstudy2.controller;

import com.korai.servletstudy2.exception.DuplicatedException;
import com.korai.servletstudy2.model.User;
import com.korai.servletstudy2.service.UserService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/users")
public class UserApiController extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, RuntimeException, IOException {
        req.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리, Java에서 라이브러리를 해석하는 역할
        User user = objectMapper.readValue(req.getInputStream(), User.class); // @NoArgsConstructor이 없으면 오류 발생, 하니씩 Set을 해서 값을 넣기 때문이다.
        System.out.println("사용자 등록 요청 들어옴");
        System.out.println(user);
        try {
            userService.register(user);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
//            resp.setStatus(200); 200은 기본값이라 생략해도 됨.
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", "사용자 등록 성공"
            )));
        } catch (DuplicatedException e) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(400);
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                "message", e.getMessage()
            )));
            return;
        }
    }
}
