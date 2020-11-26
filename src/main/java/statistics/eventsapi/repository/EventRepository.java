package statistics.eventsapi.repository;

import org.springframework.data.repository.CrudRepository;
import statistics.eventsapi.service.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
}
