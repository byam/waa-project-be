package edu.miu.waa.project.backend.domain.dto;

import edu.miu.waa.project.backend.enumSet.ListingType;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import edu.miu.waa.project.backend.enumSet.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {
    private long id;
    private String title;
    private String description;
    private Double price;
    private String address;
    private String city;
    private String image;
    private String state;
    private String zipCode;
    private ListingType listingType;
    private PropertyType propertyType;
    private PropertyStatus propertyStatus;

    private Long ownerId;

}
