package nem.kulturservice.services;

import nem.kulturservice.models.Event;
import nem.kulturservice.models.User;
import org.springframework.stereotype.Service;
import nem.kulturservice.repositories.EventRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EventService implements IEventService{

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public Set<Event> findAll() {
        Set<Event> set = new HashSet<>();
        eventRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Event save(Event object) {
        return eventRepository.save(object);
    }

    @Override
    public void delete(Event object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return eventRepository.findById(aLong);
    }
}
