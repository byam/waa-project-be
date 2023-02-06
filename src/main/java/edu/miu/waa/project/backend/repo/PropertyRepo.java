package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepo extends CrudRepository<Property, Long> {
}
