package com.pgfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.pgfinder.service.OwnerService;
import com.pgfinder.entity.Owner;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService oservice;

    @GetMapping("/getallowners")
    public List<Owner> getAllOwners() {
        return oservice.getAllOwners();
    }

    @GetMapping("/getownerdetails/{ownerId}")
    public Owner getOwnerById(@PathVariable int ownerId) {
        return oservice.getOwnerById(ownerId);
    }

    @PostMapping("/addowner")
    public void addOwner(@RequestBody Owner owner) {
        oservice.createOwner(owner);
    }

    @PutMapping("/updateowner/{ownerId}")
    public void updateOwnerDetails(@RequestBody Owner owner, @PathVariable int ownerId) {
        oservice.updateOwner(owner, ownerId);
    }

    @DeleteMapping("/deleteowner/{ownerId}")
    public void removeOwner(@PathVariable int ownerId) {
        oservice.deleteOwner(ownerId);
    }

}
