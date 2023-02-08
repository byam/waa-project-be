package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    List<Property> findAll();
    void save(PropertyDto propertyDto);
    boolean isPropertyUNAVAILABLE(long propertyId);


}
