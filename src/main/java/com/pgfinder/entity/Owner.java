package com.pgfinder.entity;

import java.util.ArrayList;
import java.util.List;

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
@DiscriminatorValue("OWNER")
public class Owner extends User {

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY) // Owner holds the list of properties
    private List<Property> properties = new ArrayList<>();

}
