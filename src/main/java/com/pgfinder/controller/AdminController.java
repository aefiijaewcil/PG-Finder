package com.pgfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.entity.Admin;
import com.pgfinder.service.AdminService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService aService;

    @GetMapping("/getalladmins")
    public List<Admin> getAllAdmins() {
        return aService.findAllAdmins();
    }

    @GetMapping("/getadmindetails/{adminId}")
    public Admin getAdminById(@PathVariable int adminId) {
        return aService.findAdminById(adminId);
    }

    @PostMapping("/addadmin")
    public void createAdmin(@RequestBody Admin admin) {
        aService.addAdmin(admin);
    }

    @PutMapping("/updateadmin/{adminId}")
    public void updateAdminDetails(@RequestBody Admin admin, @PathVariable int adminId) {
        aService.updateAdmin(admin, adminId);
    }

    @DeleteMapping("/deleteadmin/{adminId}")
    public void removeAdmin(@PathVariable int adminId) {
        aService.deleteAdmin(adminId);
    }

}