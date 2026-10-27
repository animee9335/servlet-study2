package com.korai.servletstudy2.controller;

import com.korai.servletstudy2.model.Product;
import lombok.Data;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/products")
public class ProductApiController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = new ArrayList();
        productList.add(new Product("상품1", 10000));
        productList.add(new Product("상품2", 20000));
        productList.add(new Product("상품3", 30000));
        productList.add(new Product("상품4", 40000));
        productList.add(new Product("상품5", 50000));

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(productList);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("요청들어옴!");
//        BufferedReader bufferedReader = req.getReader();
//        String json = "";
//        while ((json = bufferedReader.readLine()) != null) {
//            System.out.println(json);
//        }

        ObjectMapper objectMapper = new ObjectMapper();

        Product p = objectMapper.readValue(req.getInputStream(), Product.class);
        System.out.println(p);
    }
}

