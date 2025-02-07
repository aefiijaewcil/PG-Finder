package com.pgfinder.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.dtos.BookingDTO;
import com.pgfinder.services.BookingService;
import com.pgfinder.services.TenantService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private TenantService tenantService;

    @PostMapping("/addbooking")
    public void createBooking(@RequestParam int propertyId, @RequestParam String bookingDate,
            @RequestParam int tenantId) {
        BookingDTO bookingDto = new BookingDTO();

        bookingDto.setPropertyId(propertyId);
        bookingDto.setBookingDate(LocalDate.parse(bookingDate));
        bookingDto.setTenantId(tenantId);
        bookingService.addBooking(bookingDto);
    }

    @DeleteMapping("/cancelbooking/{bookingId}")
    public void cancelBooking(@PathVariable int bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    @GetMapping("/status/{bookingId}")
    public BookingDTO checkBookingStatus(@PathVariable int bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    // For Tenant to get all bookings

    @GetMapping("/allbookinglist/{tenantId}")
    public List<BookingDTO> getAllBookings(@PathVariable int tenantId) {
        return bookingService.getAllBookings(tenantId);
    }

    @DeleteMapping("/deletealltenantbookings/{tenantId}")
    public void deleteAllBookings(@PathVariable int tenantId) {
        bookingService.deleteAllTenantBookings(tenantId);
    }

}
