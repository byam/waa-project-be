package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.dto.request.PropertyFilterRequest;

import java.util.List;

public interface PropertyCustomRepo {
    List<Property> findByFilters(PropertyFilterRequest propertyFilterRequest);
}
