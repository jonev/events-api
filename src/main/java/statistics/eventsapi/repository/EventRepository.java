package statistics.eventsapi.repository;

import org.springframework.data.repository.CrudRepository;
import statistics.eventsapi.dto.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
}
