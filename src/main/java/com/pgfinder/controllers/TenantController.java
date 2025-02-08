package com.pgfinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.dtos.UserDTO;
import com.pgfinder.entities.Tenant;
import com.pgfinder.services.TenantService;

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
    public List<UserDTO> getAllTenants() {
        return tservice.getAllTenants();
    }

    @GetMapping("/gettenantdetails/{tenanatId}")
    public UserDTO getTenantById(@PathVariable int tenantId) {
        return tservice.getTenantById(tenantId);
    }

    @PostMapping("/addtenant")
    public void addTenant(@RequestBody UserDTO tenantDTO) {
        tservice.createTenant(tenantDTO);
    }

    @PutMapping("/updatetenant/{tenantId}")
    public void updateTenantDetails(@RequestBody UserDTO tenant, @PathVariable int tenantId) {
        tservice.updateTenant(tenant, tenantId);
    }

    @DeleteMapping("/deletetenant/{tenantId}")
    public void removeTenant(@PathVariable int tenantId) {
        tservice.deleteTenant(tenantId);
    }
}
