package com.pgfinder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyid")
    private int propertyId;

    @Column(name = "propertytype")
    private String propertyType;

    @Column(name = "address")
    private String address;

    @Column(name = "rentprice")
    private double rentPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerid")
    private Owner owner;

    @Column(name = "availabilitystatus")
    private boolean availabilityStatus;

    @Column(name = "description")
    private String description;

    public Property() {
    }

    public Property(String propertyType, String address, double rentPrice, boolean availabilityStatus, Owner owner, String description) {
        this.propertyType = propertyType;
        this.address = address;
        this.rentPrice = rentPrice;
        this.availabilityStatus = availabilityStatus;
        this.owner = owner;
        this.description = description;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getAddress() {
        return address;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
