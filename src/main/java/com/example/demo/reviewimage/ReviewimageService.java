package com.example.demo.reviewimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewimageService {
    private ReviewimageRepository reviewimageRepository;

    @Autowired
    public ReviewimageService(ReviewimageRepository repository) {
        this.reviewimageRepository = repository;
    }

    public List<Reviewimage> retrieveReviewimage() {
        return (List<Reviewimage>) reviewimageRepository.findAll();
    }

    public Optional<Reviewimage> retrieveReviewimage(Long id) {
        return reviewimageRepository.findById(id);
    }

    public List<Reviewimage> retrieveReviewimage(String FullName) {
        return null;
    }

    public Reviewimage createReviewimage(Reviewimage reviewimage) {

        return reviewimageRepository.save(reviewimage);
    }

    public Optional<Reviewimage> updateReviewimage(Long id, Reviewimage reviewimage) {
        Optional<Reviewimage> reviewimageOptional = reviewimageRepository.findById(id);
        if(!reviewimageOptional.isPresent()) {
            return reviewimageOptional;
        }

        return Optional.of(reviewimageRepository.save(reviewimage));
    }

    public boolean deleteReviewimage(Long id) {
        try {
            reviewimageRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}