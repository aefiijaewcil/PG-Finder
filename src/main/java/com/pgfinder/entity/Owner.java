package com.pgfinder.entity;

import java.util.ArrayList;
import java.util.List;

import com.pgfinder.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("owner")
public class Owner extends User {

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY) // Owner holds the list of properties
    private List<Property> properties = new ArrayList<>();

    @Override
    public void setRole(Role role) {
        if (role != Role.owner) {
            throw new IllegalArgumentException("Role must be OWNER for Owner entity");
        }
        super.setRole(role);
    }

}
