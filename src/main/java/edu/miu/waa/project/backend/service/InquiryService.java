package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.request.InquiryRequestDto;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.domain.dto.response.InquiryResponseDto;
import edu.miu.waa.project.backend.domain.dto.response.OfferResponseDto;

import java.util.List;

public interface InquiryService {
    HttpResponse save(long propertyId, InquiryRequestDto inquiryRequestDto);

    List<InquiryResponseDto> findAllByOwner(long ownerId);

    List<InquiryResponseDto> findAll();

}
