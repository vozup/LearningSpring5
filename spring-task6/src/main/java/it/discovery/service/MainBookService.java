package it.discovery.service;

import it.discovery.events.LogEvent;
import it.discovery.model.Book;
import it.discovery.repository.BookRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainBookService implements BookService {
    private final BookRepository repository;
    private final ApplicationEventPublisher publisher;

    public MainBookService(BookRepository repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
        System.out.println("Using repo: " + repository.getClass());
    }

    @Override
    @Async
    public void saveBook(Book book) {
        repository.saveBook(book);

        publisher.publishEvent(new LogEvent("Book " + book.getId() + " saved"));
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
