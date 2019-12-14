package it.discovery.fortest;

import it.discovery.service.BookService;
import lombok.Getter;

public class Server {
    @Getter
    private final BookService bookService;

    public Server(BookService bookService) {
        this.bookService = bookService;
    }

    public boolean start() {
        return bookService != null;
    }
}
