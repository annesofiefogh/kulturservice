package nem.kulturservice.services;

import nem.kulturservice.models.Event;

import java.util.List;

public interface IEventService extends CrudService<Event,Long> {
    List<Event> findAllByOrderByTimestampAsc();
}
