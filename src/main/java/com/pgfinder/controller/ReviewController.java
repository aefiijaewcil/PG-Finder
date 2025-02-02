package com.pgfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.entity.Review;
import com.pgfinder.service.ReviewService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService rService;

    @GetMapping("/addreview")
    public void createReview(Review review) {
        rService.Addreview(review);
    }

    @PutMapping("/updatereview/{id}")
    public void updateReview(@RequestBody Review review, @PathVariable int id) {
        rService.changeReview(review, id);
    }

    @DeleteMapping("/deletereview/{id}")
    public void deleteReview(@PathVariable int id) {
        rService.removeReview(id);
    }

    @GetMapping("/getreview/{id}")
    public Review getMethodName(@PathVariable int id) {
        return rService.getReview(id);
    }

}
