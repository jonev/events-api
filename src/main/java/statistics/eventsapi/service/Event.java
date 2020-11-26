package statistics.eventsapi.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String eventType;
    private String appId;
    private Instant timestamp;

    public Event() {
    }

    public Event(String userId, String eventType, String appId, Instant timestamp) {
        this.userId = userId;
        this.eventType = eventType;
        this.appId = appId;
        this.timestamp = timestamp;
    }
}
