package com.pgfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.entity.Booking;
import com.pgfinder.repo.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public boolean addBooking(Booking booking) {
        bookingRepository.save(booking);
        return true;
    }

    public boolean deleteBooking(int id) {
        bookingRepository.deleteById(id);
        return true;
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).get();
    }
}
