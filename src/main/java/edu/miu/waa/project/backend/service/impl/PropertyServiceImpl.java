package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.repo.PropertyRepo;
import edu.miu.waa.project.backend.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepo propertyRepo;

    @Override
    public List<Property> findAll() {
        List<Property> properties = new ArrayList<>();
        propertyRepo.findAll().forEach(properties::add);
        return properties;
    }
}
