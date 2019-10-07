package it.discovery.service;

import it.discovery.model.Book;
import it.discovery.repository.BookRepository;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

public class MainBookService implements BookService {
    private final BookRepository repository;

    public MainBookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveBook(Book book) {
        repository.saveBook(book);
    }

    @Override
    public Book findBookById(int id) {
        return repository.findBookById(id);
    }

    @Override
    public List<Book> findBooks() {
        return repository.findBooks();
    }

    @Override
    @CacheEvict(value = "books", allEntries = true)
    public void resetCache() {
        System.out.println("Cache cleared");
    }
}
