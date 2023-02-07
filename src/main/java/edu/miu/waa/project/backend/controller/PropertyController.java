package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.enumSet.RoleValue;
import edu.miu.waa.project.backend.service.PropertyService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
