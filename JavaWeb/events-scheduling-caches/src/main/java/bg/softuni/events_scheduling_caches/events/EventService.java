package bg.softuni.events_scheduling_caches.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @EventListener
    public void onHelloWorldEvent(HelloWorldEvent event) {
        System.out.println("Message: " + event.getMessage());
    }
}
