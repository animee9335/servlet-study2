package practice.pr01.service;

import practice.pr01.model.Book;
import practice.pr01.repository.BookRepository;

import java.util.List;

public class BookService {
    public static BookService instance;
    private BookRepository bookRepository;

    private BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static BookService getInstance() {
        if (instance ==null) {
            instance = new BookService(BookRepository.getInstance());
        }
        return instance;
    }

    public void register(Book book) {
        bookRepository.insert(book);
    }

    // 복사한 리스트를 가져옴
    public List<Book> getBookAll() {
        return bookRepository.findAll();
    }

}
