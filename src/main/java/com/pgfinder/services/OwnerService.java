package com.pgfinder.services;

import com.pgfinder.entities.Owner;
import com.pgfinder.repositories.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(int id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Owner owner, int id) {
        owner.setId(id);
        return ownerRepository.save(owner);
    }

    public void deleteOwner(int id) {
        ownerRepository.deleteById(id);
    }
}
