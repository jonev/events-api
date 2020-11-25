package statistics.eventsapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import statistics.eventsapi.dto.Event;
import statistics.eventsapi.service.EventService;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("events")
public class EventController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${controller.clientId}")
    private String allowedClientId;
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void getEvent(@RequestHeader("X-Client-Id") String clientId, @RequestBody @Valid Event event) {
        isValidClient(clientId);
        eventService.save(event);
    }

    private void isValidClient(String clientId) {
        if (!clientId.equals(allowedClientId)) {
            logger.error("Unauthorized client trying to use the API: " + clientId);
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
}
