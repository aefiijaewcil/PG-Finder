package com.pgfinder.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyid")
    private int propertyId;

    @Column(name = "propertyname")
    private String propertyName;

    @Column(name = "address")
    private String address;

    @Column(name = "rentprice")
    private double rentPrice;

    @ManyToOne
    @JoinColumn(name = "ownerid", nullable = false)
    private Owner owner;

    @Column(name = "availabilitystatus")
    private boolean availabilityStatus;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviewsList = new ArrayList<>();

    public Property() {
    }

    public Property(String propertyName, String address, double rentPrice, Owner owner, boolean availabilityStatus,
            String description) {
        this.propertyName = propertyName;
        this.address = address;
        this.rentPrice = rentPrice;
        this.owner = owner;
        this.availabilityStatus = availabilityStatus;
        this.description = description;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getAddress() {
        return address;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
