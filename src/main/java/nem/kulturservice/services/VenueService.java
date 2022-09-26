package nem.kulturservice.services;

import nem.kulturservice.models.User;
import nem.kulturservice.models.Venue;
import nem.kulturservice.repositories.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class VenueService implements IVenueService {

    private VenueRepository venueRepository;

    public VenueService (VenueRepository venueRepository){
        this.venueRepository = venueRepository;
    }

    @Override
    public Set<Venue> findAll() {
        Set<Venue> set = new HashSet<>();
        venueRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Venue save(Venue object) {
        return venueRepository.save(object);
    }

    @Override
    public void delete(Venue object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Venue> findById(Long aLong) {
        return venueRepository.findById(aLong);
    }
}
