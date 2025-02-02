package com.pgfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.entity.Admin;
import com.pgfinder.repo.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repo;

    public Admin addAdmin(Admin admin) {
        return repo.save(admin);
    }

    public Admin updateAdmin(Admin newAdmin, int Id) {
        Admin oldAdmin = repo.findById(Id).orElse(null);
        oldAdmin.setName(newAdmin.getName());
        oldAdmin.setEmail(newAdmin.getEmail());
        oldAdmin.setPhonenumber(newAdmin.getPhonenumber());
        oldAdmin.setPassword(newAdmin.getPassword());

        return repo.save(oldAdmin);
    }

    public void deleteAdmin(int id) {
        repo.deleteById(id);
    }

    public Admin findAdminById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Admin> findAllAdmins() {
        return repo.findAll();
    }
}
