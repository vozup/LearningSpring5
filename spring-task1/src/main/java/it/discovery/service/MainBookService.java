package it.discovery.service;

import java.util.List;

import it.discovery.model.Book;
import it.discovery.repository.BookRepository;
import it.discovery.repository.DBBookRepository;

public class MainBookService implements BookService {
	private final BookRepository repository;
	
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
