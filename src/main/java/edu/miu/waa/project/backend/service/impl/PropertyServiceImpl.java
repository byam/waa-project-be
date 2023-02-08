package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.FavouriteProperty;
import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.User;
import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.domain.dto.request.PropertyFilterRequest;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.domain.dto.response.UserResponseDto;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import edu.miu.waa.project.backend.repo.FavouriteRepo;
import edu.miu.waa.project.backend.repo.PropertyRepo;
import edu.miu.waa.project.backend.repo.UserRepo;
import edu.miu.waa.project.backend.service.PropertyService;
import edu.miu.waa.project.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepo propertyRepo;
    private final UserRepo userRepo;
    private final FavouriteRepo favouriteRepo;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public List<PropertyDto> findAll(PropertyFilterRequest propertyFilterRequest) {
        List<PropertyDto> results = new ArrayList<>();
        propertyRepo.findByFilters(propertyFilterRequest).forEach(p -> results.add(modelMapper.map(p, PropertyDto.class)));
        return results;
    }

    @Override
    public PropertyDto findById(long id) {
        return modelMapper.map(propertyRepo.findById(id), PropertyDto.class);
    }

    @Override
    public void save(PropertyDto propertyDto) {
        Property property = modelMapper.map(propertyDto, Property.class);
        User owner = userRepo.findById(userService.getLoggedInUser().getId()).get();
        property.setOwner(owner);
        property.setPropertyStatus(PropertyStatus.UNAVAILABLE);
        propertyRepo.save(property);
    }

    @Override

    public void favourite(long propertyId) {
        long userid = userService.getLoggedInUser().getId();
        favouriteRepo.save(FavouriteProperty.builder().propertyId(propertyId).customerId(userid).build());
    }

    @Override
    public List<PropertyDto> findFavouritesByCustomer() {
        long userid = userService.getLoggedInUser().getId();
        return favouriteRepo.findFavouritesByCustomer(userid).stream().map(p -> modelMapper.map(p, PropertyDto.class)).toList();
    }

    @Override
    public void removeFavourite(long propertyId) {
        long customerId = userService.getLoggedInUser().getId();
        favouriteRepo.deleteFavouritePropertyByPropertyIdAndAndCustomerId(propertyId, customerId);
    }


    public HttpResponse update(long id, PropertyDto propertyDto) {
        Property propertyDB = propertyRepo.findById(id).get();
        var criticalStatus = Arrays.asList(PropertyStatus.PENDING, PropertyStatus.CONTINGENT);
        if (criticalStatus.contains(propertyDB.getPropertyStatus())) {
            return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("This action is not permitted").build();

        }
        Property property = modelMapper.map(propertyDto, Property.class);
        property.setId(id);
        property.setPropertyStatus(propertyDB.getPropertyStatus());
        property.setOwner(propertyDB.getOwner());
        propertyRepo.save(property);
        return HttpResponse.builder().status(HttpStatus.OK).message("The property is deleted").build();

    }

    @Override
    public HttpResponse delete(long id) {
        Property property = propertyRepo.findById(id).get();
        var criticalStatus = Arrays.asList(PropertyStatus.PENDING, PropertyStatus.CONTINGENT);
        if (criticalStatus.contains(property.getPropertyStatus())) {
            return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("This action is not permitted").build();

        }
        propertyRepo.delete(property);
        return HttpResponse.builder().status(HttpStatus.OK).message("The property is deleted").build();
    }

    public boolean isOwner(long propertyOwnerId) {
        UserResponseDto loggedIn = userService.getLoggedInUser();
        return propertyOwnerId == loggedIn.getId();
    }


    @Override
    public HttpResponse publish(long id) {
        try {
            if (!userService.isAdmin()) {
                return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("This action is not permitted").build();

            }
            Property property = propertyRepo.findById(id).get();
            property.setPropertyStatus(PropertyStatus.AVAILABLE);
            propertyRepo.save(property);
            return HttpResponse.builder().status(HttpStatus.OK).message("Property Published").build();
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
