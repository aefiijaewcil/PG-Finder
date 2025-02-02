package com.pgfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.entity.Booking;
import com.pgfinder.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bService;

    @PostMapping("/confirm")
    public boolean confirmBooking(@RequestBody Booking booking) {
        return bService.addBooking(booking);
    }

    @DeleteMapping("/cancel/{id}")
    public boolean cancelBooking(@PathVariable int id) {
        return bService.deleteBooking(id);
    }

    @GetMapping("/status/{id}")
    public Booking checkBookingStatus(@PathVariable int id) {
        return bService.getBookingById(id);
    }
}
