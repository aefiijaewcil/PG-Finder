package com.pgfinder.dtos;

import java.time.LocalDate;

public class BookingDTO {

    private int bookingId;
    private int propertyId;
    private int tenantId;
    private LocalDate bookingDate;
    private boolean approved;

    public BookingDTO(int bookingId, int propertyId, int tenantId, LocalDate bookingDate, boolean approved) {
        this.bookingId = bookingId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.bookingDate = bookingDate;
        this.approved = approved;
    }

    public BookingDTO() {
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
