package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.request.OfferRequestDto;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.domain.dto.response.OfferResponseDto;
import edu.miu.waa.project.backend.enumSet.OfferStatus;

import java.util.List;

public interface OfferService {
    HttpResponse save(long propertyId, OfferRequestDto offerDto);

    List<OfferResponseDto> findAll();
    List<OfferResponseDto> findAllByOwner(long ownerId);

    HttpResponse updateStatus(long offerId, OfferStatus status);
}
