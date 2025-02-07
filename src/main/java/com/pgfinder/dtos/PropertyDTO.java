package com.pgfinder.dtos;

public class PropertyDTO {
    private int propertyId;
    private String propertyName;
    private String address;
    private double rentPrice;
    private int ownerId;
    private boolean availabilityStatus;
    private String description;

    public PropertyDTO() {
    }

    public PropertyDTO(int propertyId, String propertyName, String address, double rentPrice, int ownerId,
            boolean availabilityStatus, String description) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.address = address;
        this.rentPrice = rentPrice;
        this.ownerId = ownerId;
        this.availabilityStatus = availabilityStatus;
        this.description = description;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
