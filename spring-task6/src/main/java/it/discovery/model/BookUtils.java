package it.discovery.model;

import java.util.ArrayList;
import java.util.List;

public class BookUtils {
    private static int c = 1;

    public static List<Book> getRandomBooks(int count) {
        List<Book> books = new ArrayList<>();
        int booksSize = count > 0 ? count : 5;
        for (int i = c; i <= booksSize; i++, c++) {
            books.add(new Book(c, "Introduction into Spring" + i,
                    100 + i, 1993 + i));
        }
        return books;
    }

    public static Book getOneRandomBook() {
        return new Book(c++, "Introduction into Spring" + c,
                100 + c, 1900 + c);
    }
}
