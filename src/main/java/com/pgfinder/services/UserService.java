package com.pgfinder.services;

import com.pgfinder.dtos.UserDTO;
import com.pgfinder.entities.User;
import com.pgfinder.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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

    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return convertToDTO(userRepository.save(user));
    }

    public UserDTO updateUser(int id, UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user.setId(id);
        return convertToDTO(userRepository.save(user));
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getUsersByRole(String role) {
        List<User> userList = userRepository.findByRole(role);
        ArrayList<UserDTO> userDtoList = new ArrayList<>();
        for (User user : userList) {
            userDtoList.add(convertToDTO(user));
        }
        return userDtoList;
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
