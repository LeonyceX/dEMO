package com.example.demo.reviewimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviewimages")
public class ReviewimageController {

    @Autowired
    ReviewimageService reviewimageService;

    @GetMapping()
    public List<Reviewimage> getReviewimage() {
        return reviewimageService.retrieveReviewimage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewimage(@PathVariable Long id) {
        Optional<Reviewimage> reviewimage = reviewimageService.retrieveReviewimage(id);
        if(!reviewimage.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviewimage);
    }

    @GetMapping("/search")
    public List<Reviewimage> getReviewimage(@RequestParam(value = "FullName") String FullName ) {
        return reviewimageService.retrieveReviewimage(FullName);
    }

    @PostMapping()
    public ResponseEntity<?> postReviewimage(@Valid @RequestBody Reviewimage body) {
        Reviewimage reviewimage = reviewimageService.createReviewimage(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewimage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putReviewimage(@PathVariable Long id, @Valid @RequestBody Reviewimage body) {
        Optional<Reviewimage> reviewimage = reviewimageService.updateReviewimage(id, body);
        if(!reviewimage.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewimage(@PathVariable Long id) {
        if(!reviewimageService.deleteReviewimage(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}