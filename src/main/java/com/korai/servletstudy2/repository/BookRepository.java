package com.korai.servletstudy2.repository;

import com.korai.servletstudy2.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static BookRepository instance;
    private List<Book> bookList;
    private int lastID;

    BookRepository() {
        bookList = new ArrayList<>();
        lastID = 1;
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public void insert(Book book) {
        bookList.add(book);
        book.setId(lastID);
    }

    public Book findByBookName(String username) {
        for (Book book : bookList) {
            if(book.getBookName().equals(username)){
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll() {
        return bookList.stream().map(book -> new Book(book)).toList();
    }
}
