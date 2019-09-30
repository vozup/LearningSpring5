package it.discovery;

import it.discovery.repository.BookRepository;
import it.discovery.repository.DBBookRepository;
import it.discovery.repository.XmlBookRepository;
import it.discovery.service.BookService;
import it.discovery.service.MainBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Autowired
    private Environment env;

    @Value("#{xmlBookRepository.server}")
    private String xmlServer;

    @Value("${param:default}")
    private String param;

    @PostConstruct
    public void start() {
        System.out.println(xmlServer);
        System.out.println("Param: " + param + " in VM");
        String jdbc = env.getProperty("db.jdbc.url");
        Integer count = env.getProperty("db.jdbc.url.count", Integer.class, 1);
        System.out.println(jdbc + " " + count);
    }

    @Bean(name = "dbBookRepo", initMethod = "init")
    public BookRepository dbBookRepository() {
        DBBookRepository repository = new DBBookRepository();
        repository.setServer("127.0.0.1");
        return repository;
    }

    @Bean
    public BookRepository xmlBookRepository() {
        XmlBookRepository repository = new XmlBookRepository();
        repository.setServer("192.168.0.1");
        return repository;
    }

    @Bean
    public BookService mainBookService(BookRepository xmlBookRepository) {
        return new MainBookService(xmlBookRepository);
    }
}
