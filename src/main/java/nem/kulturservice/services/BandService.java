package nem.kulturservice.services;

import nem.kulturservice.models.Band;
import nem.kulturservice.models.User;
import org.springframework.stereotype.Service;
import nem.kulturservice.repositories.BandRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BandService implements IBandService {

    private BandRepository bandRepository;

    public BandService(BandRepository bandRepository){
        this.bandRepository = bandRepository;
    }

    @Override
    public Set<Band> findAll() {
        Set<Band> set = new HashSet<>();
        bandRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Band save(Band object) {
        return bandRepository.save(object);
    }

    @Override
    public void delete(Band object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return bandRepository.findById(aLong);
    }

    @Override
    public List<Band> findBandByName(String name) {
        return bandRepository.findBandByName(name);
    }
}
