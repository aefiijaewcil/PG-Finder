package com.pgfinder.services;

import com.pgfinder.dtos.UserDTO;
import com.pgfinder.entities.Tenant;
import com.pgfinder.repositories.TenantRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;

    public List<UserDTO> getAllTenants() {
        List<Tenant> tenantList = tenantRepository.findAll();
        List<UserDTO> tenantDTOList = new ArrayList<>();
        for (Tenant tenant : tenantList) {
            UserDTO tenantDTO = new UserDTO();
            BeanUtils.copyProperties(tenant, tenantDTO);
            tenantDTOList.add(tenantDTO);
        }
        return tenantDTOList;
    }

    public UserDTO getTenantById(int id) {
        Tenant tenant = tenantRepository.findById(id).orElse(null);
        if (tenant == null) {
            return null;
        }
        UserDTO tenantDTO = new UserDTO();
        BeanUtils.copyProperties(tenant, tenantDTO);
        return tenantDTO;
    }

    public void updateTenant(UserDTO tenantDTO, int id) {
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(tenantDTO, tenant);
        tenant.setId(id);
        tenantRepository.save(tenant);
    }

    public void createTenant(UserDTO tenantDTO) {
        Tenant newTenant = new Tenant();
        BeanUtils.copyProperties(tenantDTO, newTenant);
        tenantRepository.save(newTenant);
    }

    public void deleteTenant(int id) {
        tenantRepository.deleteById(id);
    }

}
