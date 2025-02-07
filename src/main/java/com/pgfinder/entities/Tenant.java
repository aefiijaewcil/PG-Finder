package com.pgfinder.entities;

import java.util.ArrayList;
import java.util.List;

import com.pgfinder.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("tenant")
public class Tenant extends User {

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WishList> wishList = new ArrayList<>();

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookingList = new ArrayList<>();

    @Override
    public void setRole(Role role) {
        if (role != Role.tenant) {
            throw new IllegalArgumentException("Role must be TENANT for Tenant entity");
        }
        super.setRole(role);
    }

}
