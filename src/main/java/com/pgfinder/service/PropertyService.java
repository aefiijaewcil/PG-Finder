package com.pgfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.entity.Property;
import com.pgfinder.repo.PropertyRepository;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(int id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public void addProperty(Property property) {
        propertyRepository.save(property);
    }

    public Property updateProperty(Property property, int id) {
        Property existingProperty = propertyRepository.findById(id).orElse(null);
        if (existingProperty != null) {
            existingProperty.setAddress(property.getAddress());
            existingProperty.setAvailabilityStatus(property.isAvailabilityStatus());
            existingProperty.setDescription(property.getDescription());
            existingProperty.setPropertyName(property.getPropertyName());
            existingProperty.setRentPrice(property.getRentPrice());
            return propertyRepository.save(existingProperty);
        } else {
            return null;
        }

    }

    public void deleteProperty(int id) {
        propertyRepository.deleteById(id);
    }

    // for owner service of listing properties(custome Query)
    public List<Property> getPropertiesByOwnerId(int ownerId) {
        return propertyRepository.findByOwnerId(ownerId);
    }

    // for owner service of delete properties(custome Query)
    public void deletePropertiesByOwnerId(int ownerId) {
        propertyRepository.deleteByOwnerId(ownerId);
    }

}
