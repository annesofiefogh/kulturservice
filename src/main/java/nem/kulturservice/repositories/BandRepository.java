package nem.kulturservice.repositories;

import nem.kulturservice.models.Band;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandRepository extends JpaRepository<Band, Long> {

    //derived queries - fungerer som sql-statements
    List<Band> findBandByName(String name);
}
