package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.dto.PropertyDto;
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
    public List<Property> findAll() {
        return propertyService.findAll();
    }

    @PostMapping("/{id}/favourite")
    public void favourite(@PathVariable long id) {
        propertyService.favourite(id);
    }

    @DeleteMapping("/{id}/favourite")
    public void removeFavourite(@PathVariable long id) {
        propertyService.removeFavourite(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PropertyDto propertyDto) {
        propertyService.save(propertyDto);
    }
}
