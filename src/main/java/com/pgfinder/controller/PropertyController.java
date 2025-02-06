package com.pgfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pgfinder.entity.Property;
import com.pgfinder.service.PropertyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/getproperties")
    public List<Property> getProperties() {
        return propertyService.getAllProperties();
    }

    @PostMapping("/addproperty")
    public void createProperty(@RequestBody Property property) {
        propertyService.addProperty(property);
    }

    @GetMapping("/getproperty/{propertyId}")
    public Property getProperty(@PathVariable int propertyId) {
        return propertyService.getPropertyById(propertyId);
    }

    @PutMapping("/updateproperty/{propertyId}")
    public Property updatePropertyDetails(@RequestBody Property property, @PathVariable int propertyId) {
        return propertyService.updateProperty(property, propertyId);
    }

    @DeleteMapping("/deleteproperty/{propertyId}")
    public void removeProperty(@PathVariable int propertyId) {
        propertyService.deleteProperty(propertyId);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Property> getPropertiesByOwnerId(@PathVariable int ownerId) {
        List<Property> propertiesList = propertyService.getPropertiesByOwnerId(ownerId);
        return propertiesList;
    }

    @DeleteMapping("/owner/{ownerId}")
    public void deletePropertiesByOwner(@PathVariable int ownerId) {
        propertyService.deletePropertiesByOwnerId(ownerId);
    }

}
