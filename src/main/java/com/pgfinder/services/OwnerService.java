package com.pgfinder.services;

import com.pgfinder.dtos.UserDTO;
import com.pgfinder.entities.Owner;
import com.pgfinder.repositories.OwnerRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<UserDTO> getAllOwners() {
        List<Owner> ownerList = ownerRepository.findAll();
        List<UserDTO> ownerDTOList = new ArrayList<>();
        for (Owner owner : ownerList) {
            UserDTO ownerDTO = new UserDTO();
            BeanUtils.copyProperties(owner, ownerDTO);
            ownerDTOList.add(ownerDTO);
        }
        return ownerDTOList;
    }

    public UserDTO getOwnerById(int id) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        if (owner == null) {
            return null;
        }
        UserDTO ownerDTO = new UserDTO();
        BeanUtils.copyProperties(owner, ownerDTO);
        return ownerDTO;
    }

    public void createOwner(UserDTO ownerDTO) {
        Owner newOwner = new Owner();
        BeanUtils.copyProperties(ownerDTO, newOwner);
        ownerRepository.save(newOwner);
    }

    public void updateOwner(UserDTO ownerDTO, int id) {
        Owner newOwner = new Owner();
        BeanUtils.copyProperties(ownerDTO, newOwner);
        newOwner.setId(id);
        ownerRepository.save(newOwner);
    }

    public void deleteOwner(int id) {
        ownerRepository.deleteById(id);
    }
}
