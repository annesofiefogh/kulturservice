package nem.kulturservice.services;

import nem.kulturservice.models.Band;

import java.util.List;

public interface IBandService extends CrudService<Band, Long> {
    List<Band> findBandByName(String name);
}
