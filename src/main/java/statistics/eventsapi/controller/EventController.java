package statistics.eventsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import statistics.eventsapi.dto.Event;
import statistics.eventsapi.service.EventService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("events")
public class EventController {

    @Value("${controller.clientId}")
    private String allowedClientId;
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void getEvent(@RequestHeader("X-Client-Id") String clientId, @RequestBody Event event) {
        isValidClient(clientId);
        eventService.save(event);
    }

    private void isValidClient(String clientId) {
        if (!clientId.equals(allowedClientId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
}
