package statistics.eventsapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Schema(description = "Event")
public class Event {

    @NotBlank(message = "userId is mandatory")
    @Schema(example = "asdf-asdf-asdf-asdf", description = "User id (should be anonymized)")
    private String userId;
    @NotBlank(message = "eventType is mandatory")
    @Schema(example = "asdf-asdf-asdf-asdf", description = "Event type (should be anonymized)")
    private String eventType;
    @NotBlank(message = "appId is mandatory")
    @Schema(example = "asdf-asdf-asdf-asdf", description = "App id (should be anonymized)")
    private String appId;
    @Schema(example = "1606418080", description = "Timestamp typically generated by the client (epoch)")
    private Instant timestamp;

    protected Event() {
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
