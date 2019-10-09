package it.discovery.config;

import it.discovery.Profiles;
import it.discovery.repository.BookRepository;
import it.discovery.repository.MySqlBookRepository;
import it.discovery.repository.OracleBookRepository;
import it.discovery.service.BookService;
import it.discovery.service.MainBookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@PropertySource("application.properties")
@EnableAsync
public class AppConfig {

    @Bean
    @ConditionOnCurrentProfile(Profiles.DEV)
    public BookRepository oracleDbRepo() {
        return new OracleBookRepository();
    }

    @Bean
    @ConditionOnCurrentProfile(Profiles.TEST)
    public BookRepository mySqlDbRepo() {
        return new MySqlBookRepository();
    }

    @Bean
    public BookService mainBookService(BookRepository bookRepository) {
        return new MainBookService(bookRepository);
    }
}
