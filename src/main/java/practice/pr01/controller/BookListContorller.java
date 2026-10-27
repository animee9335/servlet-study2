package practice.pr01.controller;


import practice.pr01.model.Book;
import practice.pr01.service.BookService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/list")
public class BookListContorller extends HttpServlet {

    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = BookService.getInstance();
        bookService.register(new Book(0, "책1", 10000));
        bookService.register(new Book(0, "책2", 20000));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("book-list", bookService.getBookAll());
        req.getRequestDispatcher("/WEB-INF/views/book-list.jsp").forward(req, resp);
    }
}
