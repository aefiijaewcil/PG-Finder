package com.pgfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.pgfinder.service.OwnerService;
import com.pgfinder.entity.Owner;

@RestController
@RequestMapping("/pgfinder")
public class OwnerController {
    @Autowired
    private OwnerService oservice;

    @GetMapping("/getallowners")
    public List<Owner> getAllOwners() {
        return oservice.findAllOwners();
    }

    @GetMapping("/getownerdetails/{id}")
    public Owner getOwnerById(@PathVariable int id) {
        return oservice.findOwnerById(id);
    }

    @PostMapping("/addowner")
    public void createOwner(@RequestBody Owner owner) {
        oservice.addOwner(owner);
    }

    @PutMapping("/updateowner/{id}")
    public void updateOwnerDetails(@RequestBody Owner owner, @PathVariable int id) {
        oservice.updateOwner(owner, id);
    }

    @DeleteMapping("/deleteowner/{id}")
    public void removeOwner(@PathVariable int id) {
        oservice.deleteOwner(id);
    }

}
