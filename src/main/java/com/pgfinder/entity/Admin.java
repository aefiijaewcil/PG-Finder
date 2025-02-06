package com.pgfinder.entity;

import com.pgfinder.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
