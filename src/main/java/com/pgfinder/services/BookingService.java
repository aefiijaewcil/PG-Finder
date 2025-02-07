package com.pgfinder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.dtos.BookingDTO;
import com.pgfinder.entities.Booking;
import com.pgfinder.entities.Tenant;
import com.pgfinder.repositories.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TenantService tenantService;

    public boolean addBooking(BookingDTO bookingDTO) {

        bookingRepository.save(convertToEntity(bookingDTO));
        return true;
    }

    public void cancelBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public BookingDTO getBookingById(int bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        return convertToDTO(booking);
    }

    public List<BookingDTO> getAllBookings(int tenantId) {
        Tenant tenant = tenantService.getTenantById(tenantId);
        List<Booking> bookingList = bookingRepository.findByTenant(tenant);
        ArrayList<BookingDTO> bookingDtoList = new ArrayList<>();
        for (Booking booking : bookingList) {
            bookingDtoList.add(convertToDTO(booking));
        }
        return bookingDtoList;
    }

    public void deleteAllTenantBookings(int tenantId) {
        Tenant tenant = tenantService.getTenantById(tenantId);
        bookingRepository.deleteByTenant(tenant);
    }

    public BookingDTO approveBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setApproved(true);
            bookingRepository.save(booking);
        }
        return convertToDTO(booking);
    }

    public BookingDTO rejectBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setApproved(false);
            bookingRepository.save(booking);
        }
        return convertToDTO(booking);
    }

    private BookingDTO convertToDTO(Booking booking) {
        if (booking == null) {
            return null;
        }
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setTenantId(booking.getTenant().getId());
        bookingDTO.setPropertyId(booking.getPropertyId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setApproved(booking.isApproved());
        return bookingDTO;
    }

    private Booking convertToEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setBookingId(bookingDTO.getBookingId());
        Tenant tenant = tenantService.getTenantById(bookingDTO.getTenantId());
        int propertyId = booking.getPropertyId();
        booking.setTenant(tenant);
        booking.setPropertyId(propertyId);
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setApproved(bookingDTO.isApproved());
        return booking;
    }

}
