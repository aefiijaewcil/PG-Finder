package com.pgfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pgfinder.services.OwnerService;
import com.pgfinder.services.PropertyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService oservice;

    @Autowired
    private PropertyService propertyService;

}
