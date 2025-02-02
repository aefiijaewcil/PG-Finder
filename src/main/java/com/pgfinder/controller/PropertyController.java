package com.pgfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/property")
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

    @GetMapping("/getproperty/{id}")
    public Property getProperty(@PathVariable int id) {
        return propertyService.getPropertyById(id);
    }

    @PutMapping("/updateproperty/{id}")
    public Property updatePropertyDetails(@RequestBody Property property,@PathVariable int id) {
        return propertyService.updateProperty(property, id);
    }

    @DeleteMapping("/deleteproperty/{id}")
    public void removeProperty(@PathVariable int id) {
        propertyService.deleteProperty(id);
    }
}
