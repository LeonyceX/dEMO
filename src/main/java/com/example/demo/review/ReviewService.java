package com.example.demo.review;

import com.example.demo.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository repository) {
        this.reviewRepository = repository;
    }

    public List<Review> retrieveReview() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Optional<Review> retrieveReview(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> retrieveReview(String descriotion) {
        return reviewRepository.findBydescription(descriotion);
    }

    public Review createReview(Review review) {

        return reviewRepository.save(review);
    }

    public Optional<Review> updateReview(Long id, Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(!reviewOptional.isPresent()) {
            return reviewOptional;
        }

        return Optional.of(reviewRepository.save(review));
    }

    public boolean deleteReview(Long id) {
        try {
            reviewRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}