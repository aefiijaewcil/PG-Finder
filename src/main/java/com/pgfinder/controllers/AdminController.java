package com.pgfinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.dtos.BookingDTO;
import com.pgfinder.dtos.PropertyDTO;
import com.pgfinder.dtos.ReviewDTO;
import com.pgfinder.dtos.UserDTO;
import com.pgfinder.services.BookingService;
import com.pgfinder.services.PropertyService;
import com.pgfinder.services.ReviewService;
import com.pgfinder.services.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private BookingService bookingService;

    // Manage users

    @GetMapping("/getallusers")
    public List<UserDTO> fetchAllUsers() {
        return userService.getAllUsers();
    }

    // updating role is not possible
    @PutMapping("/updateuser/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/removeuser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getusersbyrole")
    public List<UserDTO> fetchUsersByRole(@RequestParam String role) {
        return userService.getUsersByRole(role);
    }

    // Manage properties

    @GetMapping("/getpropertylist")
    public List<PropertyDTO> fetchPropertyList() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/getproperty/{id}")
    public PropertyDTO fetchPropertyById(@PathVariable int id) {
        return propertyService.getPropertyById(id);
    }

    @GetMapping("/getpropertiesbyowner/{ownerId}")
    public List<PropertyDTO> fetchPropertyByOwner(@PathVariable int ownerId) {
        return propertyService.getPropertiesByOwnerId(ownerId);
    }

    @DeleteMapping("/removeproperty/{id}")
    public void deleteProperty(@PathVariable int id) {
        propertyService.deleteProperty(id);
    }

    @PutMapping("/approveproperty/{id}")
    public PropertyDTO approveProperty(@PathVariable int id) {
        return propertyService.propertyApproved(id);
    }

    @PutMapping("/rejectproperty/{id}")
    public PropertyDTO rejectProperty(@PathVariable int id) {
        return propertyService.propertyRejected(id);
    }

    // Manage reviews

    @GetMapping("/getreviewsforproperty/{propertyId}")
    public List<ReviewDTO> fetchReviewsForProperty(@PathVariable int propertyId) {
        return reviewService.getReviewsForProperty(propertyId);
    }

    @GetMapping("/getreview/{reviewId}")
    public ReviewDTO fetchReview(@PathVariable int reviewId) {
        return reviewService.getReview(reviewId);
    }

    @DeleteMapping("/removereview/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewService.removeReview(reviewId);
    }

    @PutMapping("/approvereview/{reviewId}")
    public ReviewDTO approveReview(@PathVariable int reviewId) {
        return reviewService.approveReview(reviewId);
    }

    @PutMapping("/rejectreview/{reviewId}")
    public ReviewDTO rejectReview(@PathVariable int reviewId) {
        return reviewService.rejectReview(reviewId);
    }

    @DeleteMapping("/removeallreviewsbyproperty/{propertyId}")
    public void deleteAllReviewsByPropertyId(@PathVariable int propertyId) {
        reviewService.deleteAllReviewsByPropertyId(propertyId);
    }

    // Manage bookings

    @GetMapping("/getbookings/{tenantId}")
    public List<BookingDTO> fetchAllBookings(@PathVariable int tenantId) {
        return bookingService.getAllBookings(tenantId);
    }

    @PutMapping("/approvebooking/{bookingId}")
    public BookingDTO approveBooking(@PathVariable int bookingId) {
        return bookingService.approveBooking(bookingId);
    }

    @PutMapping("/rejectbooking/{bookingId}")
    public BookingDTO rejectBooking(@PathVariable int bookingId) {
        return bookingService.rejectBooking(bookingId);
    }

}