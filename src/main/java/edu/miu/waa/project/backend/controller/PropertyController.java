package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.service.PropertyService;
import edu.miu.waa.project.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private final PropertyService propertyService;
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Property> findAll() {
        return propertyService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PropertyDto propertyDto){propertyService.save(propertyDto);}
}
