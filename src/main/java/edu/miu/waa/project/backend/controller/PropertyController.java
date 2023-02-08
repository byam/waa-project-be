package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.domain.dto.request.PropertyFilterRequest;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.enumSet.ListingType;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import edu.miu.waa.project.backend.enumSet.PropertyType;
import edu.miu.waa.project.backend.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private final PropertyService propertyService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public List<PropertyDto> findAll(
            @RequestParam(name = "min_price", required = false) Double minPrice,
            @RequestParam(name = "max_price", required = false) Double maxPrice,
            @RequestParam(name = "listing_type", required = false) ListingType listingType,
            @RequestParam(name = "property_type", required = false) PropertyType propertyType,
            @RequestParam(name = "owner_id", required = false) Long ownerId,
            @RequestParam(name = "property_status", required = false) PropertyStatus propertyStatus,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "state", required = false) String state

    ) {
        PropertyFilterRequest filters = PropertyFilterRequest.builder().minPrice(minPrice).maxPrice(maxPrice)
                .listingType(listingType).propertyType(propertyType)
                .city(city).state(state).propertyStatus(propertyStatus).ownerId(ownerId)
                .build();

        return propertyService.findAll(filters);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PropertyDto findById(@PathVariable long id) {
        return propertyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PropertyDto propertyDto) {
        propertyService.save(propertyDto);
    }


    @PutMapping("/{id}/publish")
    public HttpResponse publish(@PathVariable long id) {
        System.out.println("INSIDE");
        return propertyService.publish(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponse update(@PathVariable long id, @RequestBody PropertyDto propertyDto) {
        return propertyService.update(id, propertyDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponse delete(@PathVariable long id) {
        return propertyService.delete(id);
    }
}
