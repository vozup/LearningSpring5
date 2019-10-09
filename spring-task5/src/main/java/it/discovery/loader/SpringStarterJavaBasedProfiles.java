package it.discovery.loader;

import it.discovery.Profiles;
import it.discovery.config.AppConfig;
import it.discovery.config.TestAppConfig;
import it.discovery.model.Book;
import it.discovery.model.BookUtils;
import it.discovery.repository.BookRepository;
import it.discovery.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpringStarterJavaBasedProfiles {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext()) {
            context.getEnvironment().setActiveProfiles(Profiles.DEV.toString());
            context.register(AppConfig.class, TestAppConfig.class);
            context.refresh();

            BookService service = context.getBean(BookService.class);

            service.saveAllBooks(BookUtils.getRandomBooks(10).toArray(Book[]::new));
            service.saveBook(BookUtils.getOneRandomBook());

            service.findBookById(1).whenComplete(((book, throwable) -> {
                System.out.println("finded book: " + book);
                if (throwable != null) {
                    throwable.printStackTrace();
                }
            }));

            List<Book> books = service.findBooks();
            System.out.println(books);

            System.out.println("Beans number: " + context.getBeanDefinitionCount());
            System.out.println("BookRepository beans: " +
                    Arrays.stream(context.getBeanNamesForType(BookRepository.class))
                            .collect(Collectors.joining("\n")));
            System.out.println("Bean names: " + Arrays.stream(
                    context.getBeanDefinitionNames()).collect(Collectors.joining("\n")));
        }

    }

}
