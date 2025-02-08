package com.pgfinder.services;

import com.pgfinder.dtos.UserDTO;
import com.pgfinder.entities.Admin;
import com.pgfinder.repositories.AdminRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<UserDTO> getAllAdmins() {
        List<Admin> adminList = adminRepository.findAll();
        ArrayList<UserDTO> adminDTOList = new ArrayList<>();
        for (Admin admin : adminList) {
            UserDTO adminDTOLit = new UserDTO();
            BeanUtils.copyProperties(admin, adminDTOLit);
            adminDTOList.add(adminDTOLit);
        }
        return adminDTOList;
    }

    public UserDTO getAdminById(int id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin == null) {
            return null;
        }
        UserDTO adminDTO = new UserDTO();
        BeanUtils.copyProperties(admin, adminDTO);
        return adminDTO;
    }

    public void createAdmin(UserDTO adminDTO) {
        Admin newAdmin = new Admin();
        BeanUtils.copyProperties(adminDTO, newAdmin);
        adminRepository.save(newAdmin);
    }

    public void updateAdmin(UserDTO adminDTO, int id) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDTO, admin);
        admin.setId(id);
        adminRepository.save(admin);
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }
}
