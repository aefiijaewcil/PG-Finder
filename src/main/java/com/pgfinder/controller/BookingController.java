package com.pgfinder.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.entity.Booking;
import com.pgfinder.entity.Tenant;
import com.pgfinder.service.BookingService;
import com.pgfinder.service.TenantService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private TenantService tenantService;

    @PostMapping("/addbooking")
    public void createBooking(@RequestParam int propertyId, @RequestParam String bookingDate,
            @RequestParam int tenantId) {
        Booking booking = new Booking();
        Tenant tenant = tenantService.findTenantById(tenantId);

        booking.setPropertyId(propertyId);
        booking.setBookingDate(LocalDate.parse(bookingDate));
        booking.setTenant(tenant);
        bookingService.addBooking(booking);
    }

    @DeleteMapping("/cancelbooking/{bookingId}")
    public void cancelBooking(@PathVariable int bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/status/{bookingId}")
    public Booking checkBookingStatus(@PathVariable int bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    // For Tenant to get all bookings

    @GetMapping("/allbookinglist/{tenantId}")
    public List<Booking> getAllBookings(@PathVariable int tenantId) {
        return bookingService.getAllBookings(tenantId);
    }

    @DeleteMapping("/deletealltenantbookings/{tenantId}")
    public void deleteAllBookings(@PathVariable int tenantId) {
        Tenant tenant = tenantService.findTenantById(tenantId);
        bookingService.deleteAllTenantBookings(tenant);
    }

}
