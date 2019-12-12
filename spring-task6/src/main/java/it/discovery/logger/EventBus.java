package it.discovery.logger;

import it.discovery.events.LogEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;

import java.util.List;

@AllArgsConstructor
public class EventBus {
    private List<Logger> loggers;

    @EventListener
    public void handleLogEvent(LogEvent logEvent) {
        for (Logger logger : loggers) {
            logger.log(logEvent.getMessage());
        }
    }
}
