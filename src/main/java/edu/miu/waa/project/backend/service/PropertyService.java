package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.domain.dto.request.PropertyFilterRequest;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;

import java.util.List;

public interface PropertyService {
    List<PropertyDto> findAll(PropertyFilterRequest propertyFilterRequest);

    PropertyDto findById(long id);

    void save(PropertyDto propertyDto);

    void update(long id,PropertyDto propertyDto);

    HttpResponse delete(long id);

    HttpResponse publish(long id);
}
