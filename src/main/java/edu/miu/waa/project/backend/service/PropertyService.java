package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.domain.dto.request.PropertyFilterRequest;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;

import java.util.List;

public interface PropertyService {


    void save(PropertyDto propertyDto);

    void favourite(long propertyId);

    void removeFavourite(long propertyId);

    List<PropertyDto> findFavouritesByCustomer();


    List<PropertyDto> findAll(PropertyFilterRequest propertyFilterRequest);

    PropertyDto findById(long id);


    HttpResponse update(long id, PropertyDto propertyDto);

    HttpResponse delete(long id);

    HttpResponse publish(long id);

    void updateStatus(long propertyId, PropertyStatus status);

}
