package com.pgfinder.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingid")
    private int bookingId;

    @Column(name = "propertyid")
    private int propertyId;

    @ManyToOne
    @JoinColumn(name = "tenantid", nullable = false)
    private Tenant tenant;

    @Column(name = "bookingdate")
    private LocalDate bookingDate;

    @Column(nullable = false)
    private boolean approved;

    public Booking(int bookingId, int propertyId, Tenant tenant, LocalDate bookingDate, boolean approved) {
        this.bookingId = bookingId;
        this.propertyId = propertyId;
        this.tenant = tenant;
        this.bookingDate = bookingDate;
        this.approved = approved;
    }

    public Booking() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
