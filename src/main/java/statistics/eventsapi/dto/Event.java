package statistics.eventsapi.dto;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "userId is mandatory")
    private String userId;
    @NotBlank(message = "eventType is mandatory")
    private String eventType;
    @NotBlank(message = "appId is mandatory")
    private String appId;
    private Instant timestamp;

    protected Event() {
    }

    public Event(String userId, String eventType, String appId, Instant timestamp) {
        this.userId = userId;
        this.eventType = eventType;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getEventType() {
        return eventType;
    }

    public String getAppId() {
        return appId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
