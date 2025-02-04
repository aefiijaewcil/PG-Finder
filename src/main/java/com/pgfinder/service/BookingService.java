package com.pgfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.entity.Booking;
import com.pgfinder.entity.Tenant;
import com.pgfinder.repo.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TenantService tenantService;

    public boolean addBooking(Booking booking) {
        bookingRepository.save(booking);
        return true;
    }

    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public Booking getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId).get();
    }

    public List<Booking> getAllBookings(int tenanatId) {
        Tenant tenant = tenantService.findTenantById(tenanatId);
        return bookingRepository.findByTenant(tenant);
    }

    public void deleteAllTenantBookings(Tenant tenant) {
        bookingRepository.deleteByTenant(tenant);
    }

}
