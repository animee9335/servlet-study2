package com.korai.servletstudy2.controller;

import com.korai.servletstudy2.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// SSR 구조
@WebServlet("/users")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(1, "user1", "12345", "일일일");
        req.setAttribute("user", user); // key, value
        req.setAttribute("id", user.getId());
        req.setAttribute("username", user.getUsername());
        req.setAttribute("password", user.getPassword());

        req.getRequestDispatcher("/user2.jsp").forward(req, resp); //
    }
}
