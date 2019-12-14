package it.discovery.config;

import it.discovery.bpp.InitBeanPostProcessor;
import it.discovery.bpp.MyBean;
import it.discovery.logger.EventBus;
import it.discovery.logger.FileLogger;
import it.discovery.logger.InMemoryLogger;
import it.discovery.logger.Logger;
import it.discovery.repository.BookRepository;
import it.discovery.repository.MySqlBookRepository;
import it.discovery.repository.OracleBookRepository;
import it.discovery.service.BookService;
import it.discovery.service.MainBookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

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
    public BookService mainBookService(@Qualifier("xmlDb") BookRepository bookRepository,
                                       ApplicationEventPublisher publisher) {
        return new MainBookService(bookRepository, publisher);
    }

    @Configuration
    public class LogConfiguration {
        @Bean
        public EventBus eventBus(List<Logger> loggerList) {
            return new EventBus(loggerList);
        }

        @Bean
        @Order
        public Logger fileLogger() {
            return new FileLogger();
        }

        @Bean
        @Order(Ordered.HIGHEST_PRECEDENCE)
        public Logger inMemoryLogger() {
            return new InMemoryLogger();
        }
    }

    @Configuration
    public class BeanPostProcessorConfig {
        @Bean
        public BeanPostProcessor initBeanPostProcessor() {
            return new InitBeanPostProcessor();
        }

        @Bean
        public MyBean myBean() {
            return new MyBean();
        }
    }
}
