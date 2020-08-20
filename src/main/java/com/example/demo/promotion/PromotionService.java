package com.example.demo.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {
    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository repository) {
        this.promotionRepository = repository;
    }

    public List<Promotion> retrievePromotion() {
        return (List<Promotion>) promotionRepository.findAll();
    }

    public Optional<Promotion> retrievePromotion(Long id) {
        return promotionRepository.findById(id);
    }

    public List<Promotion> retrievePromotion(String Name) {
        return null;
    }

    public Promotion createPromotion(Promotion promotion) {

        return promotionRepository.save(promotion);
    }

    public Optional<Promotion> updatePromotion(Long id, Promotion promotion) {
        Optional<Promotion> promotionOptional = promotionRepository.findById(id);
        if(!promotionOptional.isPresent()) {
            return promotionOptional;
        }

        return Optional.of(promotionRepository.save(promotion));
    }

    public boolean deletePromotion(Long id) {
        try {
            promotionRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}