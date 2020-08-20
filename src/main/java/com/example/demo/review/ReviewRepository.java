package com.example.demo.review;

import com.example.demo.review.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findBydescription(String description);
}