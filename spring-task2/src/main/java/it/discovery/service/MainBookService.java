package it.discovery.service;

import it.discovery.model.Book;
import it.discovery.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MainBookService implements BookService {
	private final BookRepository repository;

	@Autowired
	public MainBookService(BookRepository repository) {
		this.repository = repository;
		System.out.println("Using db repository");
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
}
