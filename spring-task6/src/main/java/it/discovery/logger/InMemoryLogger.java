package it.discovery.logger;

public class InMemoryLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("In-memory log: " + message);
    }
}
