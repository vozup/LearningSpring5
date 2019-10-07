package it.discovery.config;

import it.discovery.repository.BookRepository;
import it.discovery.repository.OracleBookRepository;
import it.discovery.service.BookService;
import it.discovery.service.MainBookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestAppConfig {
    @Bean
    public BookRepository oracleDbRepo() {
        return new OracleBookRepository();
    }

    @Bean
    public BookService mainBookService(BookRepository bookRepository) {
        return new MainBookService(bookRepository);
    }
}
