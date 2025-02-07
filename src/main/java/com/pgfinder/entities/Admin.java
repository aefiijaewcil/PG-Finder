package com.pgfinder.entities;

import com.pgfinder.enums.Role;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User {

    @Override
    public void setRole(Role role) {
        if (role != Role.admin) {
            throw new IllegalArgumentException("Role must be ADMIN for Admin entity");
        }
        super.setRole(role);
    }
}
