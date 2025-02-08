package com.pgfinder.entities;

import java.util.ArrayList;
import java.util.List;

import com.pgfinder.enums.Role;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("OWNER")
public class Owner extends User {

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY) // Owner holds the list of properties
    private List<Property> properties = new ArrayList<>();

    @Override
    public void setRole(Role role) {
        if (role != Role.OWNER) {
            throw new IllegalArgumentException("Role must be OWNER for Owner entity");
        }
        super.setRole(role);
    }

}
