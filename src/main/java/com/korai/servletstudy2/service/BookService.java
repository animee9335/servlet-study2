package com.korai.servletstudy2.service;

import com.korai.servletstudy2.model.Book;
import com.korai.servletstudy2.repository.BookRepository;

import java.util.List;

public class BookService {
    public static BookService instance;
    private BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService(BookRepository.getInstance());
        }
        return instance;
    }

    public void bookRegister(Book book) {
        bookRepository.insert(book);
    }

    public List<Book> getBookAll() {
        return bookRepository.findAll();
    }

}
