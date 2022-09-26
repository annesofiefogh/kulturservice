package nem.kulturservice.repositories;

import nem.kulturservice.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    //derived queries
    List<Event> findAllByOrderByTimestampAsc();
}
