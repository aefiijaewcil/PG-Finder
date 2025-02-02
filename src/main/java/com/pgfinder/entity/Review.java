package com.pgfinder.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    private int reviewid;

    @Column(name = "propertyid")
    private int propertyid;

    @Column(name = "userid")
    private int userid;

    @Column(name = "rating")
    private Enum rating;

    @Column(name = "comments")
    private String comments;

    public Review() {
    }

    public Review(int reviewid, int propertyid, int userid, Enum rating, String comments) {
        this.reviewid = reviewid;
        this.propertyid = propertyid;
        this.userid = userid;
        this.rating = rating;
        this.comments = comments;
    }

    public int getReviewid() {
        return reviewid;
    }

    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }

    public int getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(int propertyid) {
        this.propertyid = propertyid;
    }

    public int getUserid() {
        return userid;
    }
    
    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Enum getRating() {
        return rating;
    }

    public void setRating(Enum rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }



}
