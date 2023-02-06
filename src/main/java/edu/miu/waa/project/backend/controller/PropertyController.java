package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PropertyController {

    private final PropertyService propertyService;
    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @RequestMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Property> findAll(){
        return propertyService.findAll();
    }
}
