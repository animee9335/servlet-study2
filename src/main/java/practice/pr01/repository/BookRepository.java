package practice.pr01.repository;

import practice.pr01.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public static BookRepository instance;
    private List<Book> books;
    private int lastId;

    private BookRepository() {
        this.books = new ArrayList<Book>();
        lastId = 1;
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public void insert(Book book) {
        book.setId(lastId++);
        books.add(book);
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
               return book;
            }
        }
        return null;
    }

    // bookList를 복사
    public List<Book> findAll() {
        return books.stream().map(book -> new Book(book)).toList();
    }
}
