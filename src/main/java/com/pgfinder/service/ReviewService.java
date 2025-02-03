package com.pgfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.entity.Review;
import com.pgfinder.repo.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repo;

    public void Addreview(Review review) {
        repo.save(review);
    }

    public void changeReview(Review newReview, int reviewid) {

        Review oldReview = repo.findById(reviewid).get();
        oldReview.setUserid(newReview.getUserid());
        oldReview.setComments(newReview.getComments());
        oldReview.setRating(newReview.getRating());
        oldReview.setPropertyid(newReview.getPropertyid());
        repo.save(oldReview);

    }

    public void removeReview(int reviewid) {
        repo.deleteById(reviewid);
    }

    public Review getReview(int reviewid) {
        return repo.findById(reviewid).get();
    }

}
