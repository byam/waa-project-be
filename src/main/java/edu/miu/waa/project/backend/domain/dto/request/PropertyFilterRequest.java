package edu.miu.waa.project.backend.domain.dto.request;

import edu.miu.waa.project.backend.enumSet.ListingType;
import edu.miu.waa.project.backend.enumSet.PropertyType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyFilterRequest {
    private Double minPrice;
    private Double maxPrice;
    private ListingType listingType;
    private PropertyType propertyType;
}
