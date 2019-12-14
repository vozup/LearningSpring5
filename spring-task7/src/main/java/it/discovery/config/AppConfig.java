package it.discovery.config;

import it.discovery.fortest.Server;
import it.discovery.repository.BookRepository;
import it.discovery.repository.MySqlBookRepository;
import it.discovery.repository.OracleBookRepository;
import it.discovery.service.BookService;
import it.discovery.service.MainBookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@PropertySource("application.properties")
@EnableAsync
public class AppConfig {

    @Bean
    @Qualifier("oracleDb")
    public BookRepository oracleDbRepo() {
        return new OracleBookRepository();
    }

    @Bean
    @Qualifier("xmlDb")
    public BookRepository mySqlDbRepo() {
        return new MySqlBookRepository();
    }

    @Bean
    public BookService mainBookService(@Qualifier("xmlDb") BookRepository bookRepository) {
        return new MainBookService(bookRepository);
    }

    @Bean
    public Server server(BookService bookService) {
        return new Server(bookService);
    }
}
