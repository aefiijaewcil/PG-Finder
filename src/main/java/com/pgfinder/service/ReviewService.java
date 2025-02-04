package com.pgfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.entity.Property;
import com.pgfinder.entity.Review;
import com.pgfinder.repo.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repo;

    public void addReview(Review review) {

        repo.save(review);
    }

    public void changeReview(Review newReview, int reviewId) {

        Review oldReview = repo.findById(reviewId).get();
        oldReview.setTenantId(newReview.getTenantId());
        oldReview.setComments(newReview.getComments());
        oldReview.setRating(newReview.getRating());
        oldReview.setProperty(newReview.getProperty());
        repo.save(oldReview);

    }

    public void removeReview(int reviewId) {
        repo.deleteById(reviewId);
    }

    public Review getReview(int reviewId) {
        return repo.findById(reviewId).get();
    }

    public List<Review> getReviewForProperty(Property property) {
        return repo.findByProperty(property);
    }

    public void deleteAllReviewsByPropertyId(int propertyId) {
        repo.deleteByPropertyId(propertyId);
    }

}
