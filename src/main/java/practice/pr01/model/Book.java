package practice.pr01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String title;
    private int price;

    public Book(Book other) {
        this.id = other.id;
        this.title = other.title;
        this.price = other.price;
    }
}
