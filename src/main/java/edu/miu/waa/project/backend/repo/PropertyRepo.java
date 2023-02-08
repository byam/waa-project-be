package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PropertyRepo extends PropertyCustomRepo, CrudRepository<Property, Long> {

    @Query("select p.propertyStatus from Property p where p.id=:propertyId")
    String getPropertyStatus(long propertyId);
}
