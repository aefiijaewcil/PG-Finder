package com.pgfinder.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "tenantid")
    private int tenantId;

    @Column(name = "bookingdate")
    private LocalDate bookingDate;

    public Booking(int bookingId, int propertyId, int tenantId, LocalDate bookingDate) {
        this.bookingId = bookingId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.bookingDate = bookingDate;
    }

    public Booking() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
