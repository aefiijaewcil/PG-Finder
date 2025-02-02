package com.pgfinder.service;

import org.springframework.stereotype.Service;
import com.pgfinder.entity.Owner;
import com.pgfinder.repo.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository repo;

    public void addOwner(Owner owner) {
        repo.save(owner);
    }

    public void deleteOwner(int id) {
        repo.deleteById(id);
    }

    // Updating the Old Owner
    public void updateOwner(Owner newOwner, int Id) {
        Owner oldOwner = repo.findById(Id).orElse(null);
        oldOwner.setName(newOwner.getName());
        oldOwner.setEmail(newOwner.getEmail());
        oldOwner.setPhonenumber(newOwner.getPhonenumber());
        oldOwner.setPassword(newOwner.getPassword());
        repo.save(oldOwner);
    }

    public List<Owner> findAllOwners() {
        return repo.findAll();
    }

    public Owner findOwnerById(int id) {
        return repo.findById(id).orElse(null);
    }

}
