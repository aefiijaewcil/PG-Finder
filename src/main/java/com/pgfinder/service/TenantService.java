package com.pgfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.entity.Tenant;
import com.pgfinder.repo.TenantRepository;

@Service
public class TenantService {
    @Autowired
    private TenantRepository repo;

    public void addTenant(Tenant tenant) {
        repo.save(tenant);
    }

    public void deleteTenant(int id) {
        repo.deleteById(id);
    }

    // Updating the Old Tenant
    public void updateTenant(Tenant tenant, int Id) {
        Tenant oldTenant = repo.findById(Id).orElse(null);
        oldTenant.setName(tenant.getName());
        oldTenant.setEmail(tenant.getEmail());
        oldTenant.setPhonenumber(tenant.getPhonenumber());
        oldTenant.setPassword(tenant.getPassword());
        repo.save(oldTenant);
    }

    public List<Tenant> findAllTenants() {
        return repo.findAll();
    }

    public Tenant findTenantById(int id) {
        return repo.findById(id).orElse(null);
    }
}
