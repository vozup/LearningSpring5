package it.discovery.repository;

import it.discovery.model.Book;

import java.util.List;

public interface BookRepository {
    void saveAllBooks(Book savedBooks[]);

    void saveBook(Book book);

    Book findBookById(int id);

    List<Book> findBooks();
}
