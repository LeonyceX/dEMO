package com.example.demo.promotion;

import com.example.demo.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    PromotionService promotionService;

    @GetMapping()
    public List<Promotion> getPromotion() { return promotionService.retrievePromotion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPromotion(@PathVariable Long id) {
        Optional<Promotion> promotion = promotionService.retrievePromotion(id);
        if(!promotion.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(promotion);
    }

    @GetMapping("/search")
    public List<Promotion> getProduct(@RequestParam(value = "Name") String Name ) {
        return promotionService.retrievePromotion(Name);
    }
    @PostMapping()
    public ResponseEntity<?> postPromotion(@Valid @RequestBody Promotion body) {
        Promotion promotion = promotionService.createPromotion(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(promotion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putPromotion(@PathVariable Long id, @Valid @RequestBody Promotion body) {
        Optional<Promotion> promotion = promotionService.updatePromotion(id, body);
        if(!promotion.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        if(!promotionService.deletePromotion(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}