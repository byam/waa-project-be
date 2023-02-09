package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.Offer;
import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.User;
import edu.miu.waa.project.backend.domain.dto.request.OfferRequestDto;
import edu.miu.waa.project.backend.domain.dto.request.UserRequestDto;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.domain.dto.response.OfferResponseDto;
import edu.miu.waa.project.backend.enumSet.OfferStatus;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import edu.miu.waa.project.backend.repo.OfferRepo;
import edu.miu.waa.project.backend.repo.PropertyRepo;
import edu.miu.waa.project.backend.repo.UserRepo;
import edu.miu.waa.project.backend.service.OfferService;
import edu.miu.waa.project.backend.service.PropertyService;
import edu.miu.waa.project.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final PropertyService propertyService;
    private final UserRepo userRepo;
    private final OfferRepo offerRepo;
    private final PropertyRepo propertyRepo;


    private final List<PropertyStatus> allowedPropertyStatusForOffer = Arrays.asList(PropertyStatus.AVAILABLE, PropertyStatus.PENDING);
    private final List<OfferStatus> allowedOfferStatusForCustomer = Arrays.asList(OfferStatus.CANCELLED);
    private final List<OfferStatus> allowedOfferStatusForOwner = Arrays.asList(OfferStatus.APPROVED, OfferStatus.CANCELLED);

    @Override
    public HttpResponse save(long propertyId, OfferRequestDto offerDto) {

        if (!userService.isCustomer()) {
            return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("Only Customer can send offer").build();

        }
        Property property = propertyRepo.findById(propertyId).get();
        if (!allowedPropertyStatusForOffer.contains(property.getPropertyStatus())) {
            return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("The property is not available").build();
        }

        Offer offer = modelMapper.map(offerDto, Offer.class);
        User user = userRepo.findById(userService.getLoggedInUser().getId()).get();
        offer.setUser(user);
        offer.setProperty(property);
        offer.setOfferStatus(OfferStatus.PENDING);
        offerRepo.save(offer);
        return HttpResponse.builder().status(HttpStatus.CREATED).message("Success").build();
    }

    @Override
    public List<OfferResponseDto> findAll() {
        UserRequestDto loggedInUser = userService.getLoggedInUser();
        if (userService.isCustomer()) {
            return offerRepo.findAllByUserId(loggedInUser.getId()).stream().map(o -> {
                OfferResponseDto offer = modelMapper.map(o, OfferResponseDto.class);
                offer.setPropertyId(o.getProperty().getId());
                return offer;
            }).toList();
        }
        if (userService.isOwner()) {
            return findAllByOwner(loggedInUser.getId());
        }
        return null;
    }

    @Override
    public List<OfferResponseDto> findAllByOwner(long ownerId) {

        return offerRepo.findAllByOwnerId(ownerId).stream().map(o -> {
            OfferResponseDto offer = modelMapper.map(o, OfferResponseDto.class);
            offer.setPropertyId(o.getProperty().getId());
            return offer;
        }).toList();
    }

    @Override
    public HttpResponse updateStatus(long offerId, OfferStatus status) {
        Offer offer = offerRepo.findById(offerId).get();

        if (userService.isOwner() && !allowedOfferStatusForOwner.contains(status)) {
            return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("This action is not permitted").build();
        }

        if (userService.isCustomer() && !allowedOfferStatusForCustomer.contains(status) && offer.getProperty().getPropertyStatus() != PropertyStatus.CONTINGENT) {
            return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("This action is not permitted").build();
        }

        offer.setOfferStatus(status);

        //sync with product status
        if (userService.isOwner()) {
            if (status.equals(OfferStatus.APPROVED)) {
                propertyService.updateStatus(offer.getProperty().getId(), PropertyStatus.PENDING);
            }
            if (status.equals(OfferStatus.REJECTED)) {
                propertyService.updateStatus(offer.getProperty().getId(), PropertyStatus.AVAILABLE);
            }
        }

        //save offer
        offerRepo.save(offer);
        return HttpResponse.builder().status(HttpStatus.OK).message("Success").build();

    }
}
