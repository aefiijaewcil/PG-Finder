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
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService aService;

    @GetMapping("/getalladmins")
    public List<Admin> getAllAdmins() {
        return aService.findAllAdmins();
    }

    @GetMapping("/getadmindetails/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return aService.findAdminById(id);
    }

    @PostMapping("/addadmin")
    public void createAdmin(@RequestBody Admin admin) {
        aService.addAdmin(admin);
    }

    @PutMapping("/updateadmin/{id}")
    public void updateAdminDetails(@RequestBody Admin admin, @PathVariable int id) {
        aService.updateAdmin(admin, id);
    }

    @DeleteMapping("/deleteadmin/{id}")
    public void removeAdmin(@PathVariable int id) {
        aService.deleteAdmin(id);
    }

}