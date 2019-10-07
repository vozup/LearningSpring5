package it.discovery.repository;

import it.discovery.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handles database-related book operations
 *
 * @author morenets
 */
public class MySqlBookRepository implements BookRepository {
    private final Map<Integer, Book> books = new HashMap<>();

    private int counter = 0;

    private String server = "localhost";

    private String db = "library";

    public void init() {
        System.out.println("Started MySQL DB repository with server:" + server + " and database: " + db);
    }

    /**
     * @func shutdown() or close() spring calling automatic
     */
    public void shutdown() {
        System.out.println("Shutting down repository ... ");
    }

    //...
    //public void close() {
    //    System.out.println("Closing repository ... ");
    //}

    @Override
    public void saveBook(Book book) {
        if (book.getId() == 0) {
            counter++;
            book.setId(counter);
        }

        books.put(book.getId(), book);

        System.out.println("Saved book " + book + " to MySQL DB");
    }

    @Override
    public void saveAllBooks(Book savedBooks[]) {
        for (Book b : savedBooks) {
            books.put(b.getId(), b);
        }
    }

    @Override
    public Book findBookById(int id) {
        return books.get(id);
    }

    @Override
    public List<Book> findBooks() {
        return new ArrayList<>(books.values());
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }
}
