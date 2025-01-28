package bg.softuni.events_scheduling_caches.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final ApplicationEventPublisher eventPublisher;

    public EventController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("/fire-event")
    public String fireEvent() {

        eventPublisher.publishEvent(new HelloWorldEvent(this, "Hello"));

        return "fire-event";
    }
}
