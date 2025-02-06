package com.pgfinder.service;

import com.pgfinder.entity.Tenant;
import com.pgfinder.repo.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Tenant getTenantById(int id) {
        return tenantRepository.findById(id).orElse(null);
    }

    public Tenant createTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public Tenant updateTenant(Tenant tenant, int id) {
        tenant.setId(id);
        return tenantRepository.save(tenant);
    }

    public void deleteTenant(int id) {
        tenantRepository.deleteById(id);
    }

}
