package nem.kulturservice.repositories;

import nem.kulturservice.models.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
