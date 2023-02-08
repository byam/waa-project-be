package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.Inquiry;
import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.User;
import edu.miu.waa.project.backend.domain.dto.request.InquiryRequestDto;
import edu.miu.waa.project.backend.domain.dto.request.UserRequestDto;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.domain.dto.response.InquiryResponseDto;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import edu.miu.waa.project.backend.repo.InquiryRepo;
import edu.miu.waa.project.backend.repo.PropertyRepo;
import edu.miu.waa.project.backend.repo.UserRepo;
import edu.miu.waa.project.backend.service.InquiryService;
import edu.miu.waa.project.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final PropertyRepo propertyRepo;
    private final UserRepo userRepo;
    private final InquiryRepo inquiryRepo;


    private final List<PropertyStatus> allowedPropertyStatusForOffer = Arrays.asList(PropertyStatus.AVAILABLE, PropertyStatus.PENDING);


    @Override
    public HttpResponse save(long propertyId, InquiryRequestDto inquiryRequestDto) {
        if (!userService.isCustomer()) {
            return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("Only Customer can send offer").build();
        }

        Property property = propertyRepo.findById(propertyId).get();

        if (!allowedPropertyStatusForOffer.contains(property.getPropertyStatus())) {
            return HttpResponse.builder().status(HttpStatus.FORBIDDEN).message("The property is not available").build();
        }

        Inquiry inquiry = modelMapper.map(inquiryRequestDto, Inquiry.class);
        User user = userRepo.findById(userService.getLoggedInUser().getId()).get();
        inquiry.setUser(user);
        inquiry.setProperty(property);

        inquiryRepo.save(inquiry);
        return HttpResponse.builder().status(HttpStatus.CREATED).message("Success").build();
    }



    @Override
    public List<InquiryResponseDto> findAll() {
        UserRequestDto loggedInUser = userService.getLoggedInUser();
        return inquiryRepo.findAllByUserId(loggedInUser.getId()).stream().map(o -> modelMapper.map(o, InquiryResponseDto.class)).toList();
    }
}
