package it.discovery.service;

import it.discovery.model.Book;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BookService {
    void saveAllBooks(Book savedBooks[]);

    public void saveBook(Book book);

    public CompletableFuture<Book> findBookById(int id);

    public List<Book> findBooks();
}
