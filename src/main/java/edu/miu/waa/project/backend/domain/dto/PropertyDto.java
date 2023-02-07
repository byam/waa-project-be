package edu.miu.waa.project.backend.domain.dto;

import edu.miu.waa.project.backend.enumSet.ListingType;
import edu.miu.waa.project.backend.enumSet.PropertyType;
import lombok.Data;

@Data
public class PropertyDto {
    private String title;
    private String description;
    private Double price;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private ListingType listingType;
    private PropertyType propertyType;

    private Long ownerId;

}
