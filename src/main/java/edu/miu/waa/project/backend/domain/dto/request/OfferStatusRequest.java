package edu.miu.waa.project.backend.domain.dto.request;

import edu.miu.waa.project.backend.enumSet.OfferStatus;
import lombok.Data;

@Data
public class OfferStatusRequest {
    OfferStatus status;
}
