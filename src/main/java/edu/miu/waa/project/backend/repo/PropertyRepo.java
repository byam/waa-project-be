package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PropertyRepo extends PropertyCustomRepo, CrudRepository<Property, Long> {

    @Query("update Property p set p.propertyStatus=:status  where p.id=:propertyId")
    String updatePropertyStatus(@Param("propertyId") long propertyId, @Param("status") PropertyStatus status);
}
