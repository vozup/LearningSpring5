package it.discovery.loader;

import it.discovery.AppConfig;
import it.discovery.model.Book;
import it.discovery.repository.BookRepository;
import it.discovery.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SpringStarterJavaBased {
    private static final Logger logger = Logger.getLogger(SpringStarterJavaBased.class.toString());

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            BookService service = context.getBean(BookService.class);

            for (int i = 1; i < 10; i++) {
                service.saveBook(new Book(i, "Name-" + i, 1993 + i, 100 + i));
            }


            logger.info(service.findBookById(1).getName());
            logger.info(service.findBookById(1).getName());
            logger.info(service.findBookById(1).getName());
            logger.info(service.findBookById(2).getName());
            service.resetCache();
            service.saveBook(new Book(2, "Name-222", 1995, 120));
            logger.info(service.findBookById(2).getName());
            logger.info(service.findBookById(1).getName());
            logger.info(service.findBookById(1).getName());

            List<Book> books = service.findBooks();
            System.out.println(books);

            System.out.println("Beans number: " + context.getBeanDefinitionCount());
            System.out.println("BookRepository beans: " +
                    Arrays.stream(context.getBeanNamesForType(BookRepository.class))
                            .collect(Collectors.joining(",")));
            System.out.println("Bean names: " + Arrays.stream(
                    context.getBeanDefinitionNames()).collect(Collectors.joining(",")));
        }

    }

}
