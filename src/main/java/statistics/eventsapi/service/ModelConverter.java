package statistics.eventsapi.service;

public class ModelConverter {
    public static Event convert(statistics.eventsapi.dto.Event event) {
        return new Event(event.getUserId(),
                event.getEventType(),
                event.getAppId(),
                event.getTimestamp());
    }
}
