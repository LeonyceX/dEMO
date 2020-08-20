package com.example.demo.review;

import com.example.demo.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping()
    public List<Review> getReviews() {
        return reviewService.retrieveReview();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        Optional<Review> review = reviewService.retrieveReview(id);
        if(!review.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review);
    }

    @GetMapping("/search")
    public List<Review> getReview(@RequestParam(value = "description") String description ) {
        return reviewService.retrieveReview(description);
    }

    @PostMapping()
    public ResponseEntity<?> postReview(@Valid @RequestBody Review body) {
        Review review = reviewService.createReview(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putReview(@PathVariable Long id, @Valid @RequestBody Review body) {
        Optional<Review> review = reviewService.updateReview(id, body);
        if(!review.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        if(!reviewService.deleteReview(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}