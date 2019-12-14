package it.discovery.service;

import it.discovery.model.Book;
import it.discovery.repository.BookRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainBookService implements BookService {
    private final BookRepository repository;

    public MainBookService(BookRepository repository) {
        this.repository = repository;
        System.out.println("Using repo: " + repository.getClass());
    }

    @Override
    @Async
    public void saveBook(Book book) {
        repository.saveBook(book);
    }

    @Override
    @Async
    public CompletableFuture<Book> findBookById(int id) {
        return CompletableFuture.completedFuture(repository.findBookById(id));
    }

    @Override
    public List<Book> findBooks() {
        return repository.findBooks();
    }

    @Override
    public void saveAllBooks(Book savedBooks[]) {
        repository.saveAllBooks(savedBooks);
    }
}
