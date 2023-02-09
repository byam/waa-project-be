package edu.miu.waa.project.backend.domain.dto.response;

import edu.miu.waa.project.backend.enumSet.OfferStatus;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferResponseDto {
    private long id;
    private String message;
    private OfferStatus offerStatus;
    private PropertyStatus propertyStatus;
    private Double price;
    private long propertyId;

}
