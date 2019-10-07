package it.discovery;

import it.discovery.repository.BookRepository;
import it.discovery.repository.DBBookRepository;
import it.discovery.repository.XmlBookRepository;
import it.discovery.service.BookService;
import it.discovery.service.MainBookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "dbBookRepo", initMethod = "init")
    public BookRepository dbBookRepository() {
        DBBookRepository repository = new DBBookRepository();
        repository.setServer("127.0.0.1");
        return repository;
    }

    @Bean
    public BookRepository xmlBookRepository() {
        return new XmlBookRepository();
    }

    @Bean
    public BookService mainBookService(BookRepository xmlBookRepository) {
        return new MainBookService(xmlBookRepository);
    }
}
