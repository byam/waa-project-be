package edu.miu.waa.project.backend.domain.dto;

import edu.miu.waa.project.backend.enumSet.OfferStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfferDto {
    private long id;
    private String message;
    private OfferStatus offerStatus;
    private Double price;

}
