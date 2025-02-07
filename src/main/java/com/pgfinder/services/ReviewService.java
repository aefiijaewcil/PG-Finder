package com.pgfinder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.dtos.PropertyDTO;
import com.pgfinder.dtos.ReviewDTO;
import com.pgfinder.entities.Property;
import com.pgfinder.entities.Review;
import com.pgfinder.repositories.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PropertyService propertyService;

    public void addReview(ReviewDTO reviewDTO) {
        Review review = convertToEntity(reviewDTO);
        reviewRepository.save(review);
    }

    public void changeReview(ReviewDTO newReviewDTO, int reviewId) {
        Review newReview = convertToEntity(newReviewDTO);
        newReview.setReviewId(reviewId);
        reviewRepository.save(newReview);
    }

    public void removeReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public ReviewDTO getReview(int reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        return convertToDTO(review);
    }

    public ReviewDTO approveReview(int id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            review.setApproved(true);
            reviewRepository.save(review);
        }
        return convertToDTO(review);
    }

    public ReviewDTO rejectReview(int id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            review.setApproved(false);
            reviewRepository.save(review);
        }
        return convertToDTO(review);
    }

    public List<ReviewDTO> getReviewForProperty(PropertyDTO propertyDTO) {
        Property property = new Property();
        BeanUtils.copyProperties(propertyDTO, property);
        List<Review> reviews = reviewRepository.findByProperty(property);
        ArrayList<ReviewDTO> reviewDTOList = new ArrayList<>();
        for (Review review : reviews) {
            reviewDTOList.add(convertToDTO(review));
        }

        return reviewDTOList;
    }

    public void deleteAllReviewsByPropertyId(int propertyId) {
        reviewRepository.deleteByPropertyId(propertyId);
    }

    private ReviewDTO convertToDTO(Review review) {
        if (review == null) {
            return null;
        }
        return new ReviewDTO(
                review.getReviewId(),
                review.getProperty().getPropertyId(),
                review.getTenantId(),
                review.getRating(),
                review.getComments(),
                review.isApproved());
    }

    private Review convertToEntity(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setReviewId(reviewDTO.getReviewId());
        PropertyDTO propertyDTO = propertyService.getPropertyById(reviewDTO.getPropertyId());
        Property property = new Property();
        BeanUtils.copyProperties(propertyDTO, property);
        review.setProperty(property);
        review.setTenantId(reviewDTO.getTenantId());
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());
        review.setApproved(reviewDTO.isApproved());
        return review;
    }
}
