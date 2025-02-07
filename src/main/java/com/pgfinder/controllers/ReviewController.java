package com.pgfinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.dtos.PropertyDTO;
import com.pgfinder.dtos.ReviewDTO;
import com.pgfinder.enums.Rating;
import com.pgfinder.services.PropertyService;
import com.pgfinder.services.ReviewService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/addreview")
    public void createReview(@RequestParam String comments, @RequestParam String rating, @RequestParam int tenantId,
            @RequestParam int propertyId) {
        ReviewDTO reviewDTO = new ReviewDTO();

        reviewDTO.setPropertyId(propertyId);
        reviewDTO.setTenantId(tenantId);
        reviewDTO.setComments(comments);
        reviewDTO.setRating(Rating.valueOf(rating));
        reviewService.addReview(reviewDTO);
    }

    @PutMapping("/updatereview/{reviewId}")
    public void updateReview(@RequestParam String comments, @RequestParam String rating,
            @PathVariable int reviewId) {
        ReviewDTO oldReviewDTO = reviewService.getReview(reviewId);
        oldReviewDTO.setComments(comments);
        oldReviewDTO.setRating(Rating.valueOf(rating));
        reviewService.changeReview(oldReviewDTO, reviewId);
    }

    @DeleteMapping("/deletereview/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewService.removeReview(reviewId);
    }

    @GetMapping("/getreview/{reviewId}")
    public ReviewDTO getReview(@PathVariable int reviewId) {
        return reviewService.getReview(reviewId);
    }

    // For Property Methods

    @GetMapping("/getreviewslist")
    public List<ReviewDTO> getReviewsList(@RequestParam int propertyId) {
        PropertyDTO propertyDTO = propertyService.getPropertyById(propertyId);
        return reviewService.getReviewForProperty(propertyDTO);
    }

    @DeleteMapping("/deleteallreviews/{propertyId}")
    public void deleteAllReviews(@PathVariable int propertyId) {
        reviewService.deleteAllReviewsByPropertyId(propertyId);
    }
}
