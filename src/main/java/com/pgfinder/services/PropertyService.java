package com.pgfinder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.dtos.PropertyDTO;
import com.pgfinder.entities.Property;
import com.pgfinder.repositories.PropertyRepository;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private OwnerService ownerService;

    public List<PropertyDTO> getAllProperties() {
        List<Property> propertyList = propertyRepository.findAll();
        ArrayList<PropertyDTO> propertyDTOList = new ArrayList<>();
        for (Property property : propertyList) {
            propertyDTOList.add(convertToDTO(property));
        }

        return propertyDTOList;
    }

    public PropertyDTO getPropertyById(int id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            return null;
        }
        return convertToDTO(property);
    }

    public void addProperty(PropertyDTO propertyDTO) {
        Property property = convertToEntity(propertyDTO);
        propertyRepository.save(property);
    }

    public PropertyDTO updateProperty(PropertyDTO propertyDTO, int id) {
        Property property = convertToEntity(propertyDTO);
        property.setPropertyId(id);
        return convertToDTO(propertyRepository.save(property));
    }

    public void deleteProperty(int id) {
        propertyRepository.deleteById(id);
    }

    public List<PropertyDTO> getPropertiesByOwnerId(int ownerId) {
        List<Property> propertyList = propertyRepository.findByOwnerId(ownerId);
        ArrayList<PropertyDTO> propertyDTOList = new ArrayList<>();
        for (Property property : propertyList) {
            propertyDTOList.add(convertToDTO(property));
        }
        return propertyDTOList;
    }

    public void deletePropertiesByOwnerId(int ownerId) {
        propertyRepository.deleteByOwnerId(ownerId);
    }

    public PropertyDTO propertyApproved(int id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            property.setApproved(true);
            propertyRepository.save(property);
        }
        return convertToDTO(property);
    }

    public PropertyDTO propertyRejected(int id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            property.setApproved(false);
            propertyRepository.save(property);
        }
        return convertToDTO(property);
    }

    private PropertyDTO convertToDTO(Property property) {
        return new PropertyDTO(
                property.getPropertyId(),
                property.getPropertyName(),
                property.getAddress(),
                property.getRentPrice(),
                property.getOwner().getId(),
                property.isAvailabilityStatus(),
                property.getDescription());
    }

    private Property convertToEntity(PropertyDTO propertyDTO) {
        Property property = new Property();
        property.setPropertyId(propertyDTO.getPropertyId());
        property.setPropertyName(propertyDTO.getPropertyName());
        property.setAddress(propertyDTO.getAddress());
        property.setRentPrice(propertyDTO.getRentPrice());
        property.setOwner(ownerService.getOwnerById(propertyDTO.getOwnerId()));
        property.setAvailabilityStatus(propertyDTO.isAvailabilityStatus());
        property.setDescription(propertyDTO.getDescription());
        return property;
    }
}
