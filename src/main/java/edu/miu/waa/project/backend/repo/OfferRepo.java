package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepo extends CrudRepository<Offer, Long> {

    List<Offer> findAllByUserId(long userId);

}
