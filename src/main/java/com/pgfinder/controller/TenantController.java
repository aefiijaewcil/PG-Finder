package com.pgfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.entity.Tenant;
import com.pgfinder.service.TenantService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tenants")
public class TenantController {
    @Autowired
    private TenantService tservice;

    @GetMapping("/getalltenants")
    public List<Tenant> getAllTenants() {
        return tservice.getAllTenants();
    }

    @GetMapping("/gettenantdetails/{tenanatId}")
    public Tenant getTenantById(@PathVariable int tenantId) {
        return tservice.getTenantById(tenantId);
    }

    @PostMapping("/addtenant")
    public void addTenant(@RequestBody Tenant tenant) {
        tservice.createTenant(tenant);
    }

    @PutMapping("/updatetenant/{tenantId}")
    public void updateTenantDetails(@RequestBody Tenant tenant, @PathVariable int tenantId) {
        tservice.updateTenant(tenant, tenantId);
    }

    @DeleteMapping("/deletetenant/{tenantId}")
    public void removeTenant(@PathVariable int tenantId) {
        tservice.deleteTenant(tenantId);
    }
}
