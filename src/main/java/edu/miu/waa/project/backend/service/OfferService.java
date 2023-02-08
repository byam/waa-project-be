package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.OfferDto;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.enumSet.OfferStatus;

public interface OfferService {
    HttpResponse save(long propertyId, OfferDto offerDto);

    HttpResponse updateStatus(long offerId, OfferStatus status);
}
