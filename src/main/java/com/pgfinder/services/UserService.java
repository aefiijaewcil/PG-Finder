package com.pgfinder.services;

import com.pgfinder.dtos.LoginDTO;
import com.pgfinder.dtos.UserDTO;
import com.pgfinder.entities.Admin;
import com.pgfinder.entities.Owner;
import com.pgfinder.entities.Tenant;
import com.pgfinder.entities.User;
import com.pgfinder.enums.Role;
import com.pgfinder.repositories.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private TenantService tenantService;

    @Autowired
    private AdminService adminService;

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        ArrayList<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList) {
            userDTOList.add(convertToDTO(user));
        }

        return userDTOList;
    }

    public UserDTO getUserById(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        return convertToDTO(user);
    }

    public void createUser(UserDTO userDTO) {
        Role role = userDTO.getRole();
        if (("ADMIN") == role.toString()) {
            adminService.createAdmin(userDTO);
        } else if (("OWNER") == role.toString()) {
            ownerService.createOwner(userDTO);
        } else if (("TENANT") == role.toString()) {
            tenantService.createTenant(userDTO);
        }
    }

    public UserDTO updateUser(int id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setUserName(userDTO.getUserName());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setRole(userDTO.getRole()); // role will not be get updated
        return convertToDTO(userRepository.save(existingUser));
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getUsersByRole(String role) {
        List<User> userList = userRepository.findByRole(Role.valueOf(role));
        ArrayList<UserDTO> userDtoList = new ArrayList<>();
        for (User user : userList) {
            userDtoList.add(convertToDTO(user));
        }
        return userDtoList;
    }

    public LoginDTO validateUser(String userName, String password) {
        Object obj = userRepository.findIdAndRoleByUsernameAndPassword(userName, password);
        if (obj == null) {
            return null;
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(obj, loginDTO);
        return loginDTO;
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getRole());
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        return user;
    }
}
