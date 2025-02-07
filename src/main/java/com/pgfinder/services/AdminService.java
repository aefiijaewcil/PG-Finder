package com.pgfinder.services;

import com.pgfinder.entities.Admin;
import com.pgfinder.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin, int id) {
        admin.setId(id);
        return adminRepository.save(admin);
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }
}
