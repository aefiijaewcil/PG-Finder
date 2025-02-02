package com.pgfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.entity.Tenant;
import com.pgfinder.service.TenantService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TenantController {
    @Autowired
    private TenantService tservice;

    @GetMapping("/getalltenants")
    public List<Tenant> getAllTenants() {
        return tservice.findAllTenants();
    }

    @GetMapping("/gettenantdetails/{id}")
    public Tenant getTenantById(@PathVariable int id) {
        return tservice.findTenantById(id);
    }

    @PostMapping("/addtenant")
    public void createTenant(@RequestBody Tenant tenant) {
        tservice.addTenant(tenant);
    }

    @PutMapping("/updatetenant/{id}")
    public void updateTenantDetails(@RequestBody Tenant tenant, @PathVariable int id) {
        tservice.updateTenant(tenant, id);
    }

    @DeleteMapping("/deletetenant/{id}")
    public void removeTenant(@PathVariable int id) {
        tservice.deleteTenant(id);
    }
}
