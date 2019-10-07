package it.discovery.model;

import java.util.ArrayList;
import java.util.List;

public class BookUtils {
    public static List<Book> getRandomBooks(int count) {
        List<Book> books = new ArrayList<>();
        int booksSize = count > 0 ? count : 5;
        for (int i = 0; i < booksSize; i++) {
            books.add(new Book(i + 1, "Introduction into Spring" + i,
                    100 + i, 1993 + i));
        }
        return books;
    }
}
