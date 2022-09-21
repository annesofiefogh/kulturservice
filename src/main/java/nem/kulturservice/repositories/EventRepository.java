package nem.kulturservice.repositories;

import nem.kulturservice.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
