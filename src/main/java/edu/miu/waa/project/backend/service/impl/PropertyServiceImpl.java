package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.FavouriteProperty;
import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.User;
import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import edu.miu.waa.project.backend.repo.FavouriteRepo;
import edu.miu.waa.project.backend.repo.PropertyRepo;
import edu.miu.waa.project.backend.repo.UserRepo;
import edu.miu.waa.project.backend.service.PropertyService;
import edu.miu.waa.project.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Property> findAll() {
        List<Property> properties = new ArrayList<>();
        propertyRepo.findAll().forEach(properties::add);
        return properties;
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

}
