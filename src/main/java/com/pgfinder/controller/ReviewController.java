package com.pgfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.entity.Property;
import com.pgfinder.enums.Rating;
import com.pgfinder.entity.Review;
import com.pgfinder.service.PropertyService;
import com.pgfinder.service.ReviewService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/addreview")
    public void createReview(@RequestParam String comments, @RequestParam String rating, @RequestParam int tenantId,
            @RequestParam int propertyId) {
        Review review = new Review();

        review.setProperty(propertyService.getPropertyById(propertyId));
        review.setTenantId(tenantId);
        review.setComments(comments);
        review.setRating(Rating.valueOf(rating));
        reviewService.addReview(review);
    }

    @PutMapping("/updatereview/{reviewId}")
    public void updateReview(@RequestParam String comments, @RequestParam String rating,
            @PathVariable int reviewId) {
        Review oldReview = reviewService.getReview(reviewId);
        oldReview.setComments(comments);
        oldReview.setRating(Rating.valueOf(rating));
        reviewService.changeReview(oldReview, reviewId);
    }

    @DeleteMapping("/deletereview/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewService.removeReview(reviewId);
    }

    @GetMapping("/getreview/{reviewId}")
    public Review getReview(@PathVariable int reviewId) {
        return reviewService.getReview(reviewId);
    }

    // For Property Methods

    @GetMapping("/getreviewslist")
    public List<Review> getReviewsList(@RequestParam int propertyId) {
        Property property = propertyService.getPropertyById(propertyId);
        return reviewService.getReviewForProperty(property);
    }

    @DeleteMapping("/deleteallreviews/{propertyId}")
    public void deleteAllReviews(@PathVariable int propertyId) {
        reviewService.deleteAllReviewsByPropertyId(propertyId);
    }
}
