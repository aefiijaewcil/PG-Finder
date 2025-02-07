package com.pgfinder.dtos;

import com.pgfinder.enums.Rating;

public class ReviewDTO {

    private int reviewId;
    private int propertyId;
    private int tenantId;
    private Rating rating;
    private String comments;
    private boolean approved;

    public ReviewDTO() {
    }

    public ReviewDTO(int reviewid, int propertyId, int tenantId, Rating rating, String comments, boolean approved) {
        this.reviewId = reviewid;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.rating = rating;
        this.comments = comments;
        this.approved = approved;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
