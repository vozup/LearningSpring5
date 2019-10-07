package it.discovery.service;

import it.discovery.model.Book;

import java.util.List;

public interface BookService {
    void saveAllBooks(Book savedBooks[]);

    public void saveBook(Book book);

    public Book findBookById(int id);

    public List<Book> findBooks();
}
