package it.discovery.loader;

import it.discovery.model.Book;
import it.discovery.repository.DBBookRepository;
import it.discovery.service.MainBookService;

public class BootstrapLoader {

    public static void main(String[] args) {
        var bookRepository = new DBBookRepository();
        bookRepository.setDb("server1");
        var service = new MainBookService(bookRepository);
        Book book = new Book();
        book.setName("Introduction into Spring");
        book.setPages(100);
        book.setYear(2016);
        service.saveBook(book);

        var books = service.findBooks();
        System.out.println(books);
    }

}
