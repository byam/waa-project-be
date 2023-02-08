package edu.miu.waa.project.backend.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyFilterRequest {
    private Double minPrice;
    private Double maxPrice;
    private Double listingType;
    private Double propertyType;
}
