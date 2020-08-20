package com.example.demo.brand;

import com.example.demo.product.Product;
import com.example.demo.reviewimage.Reviewimage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping()
    public List<Brand> getBrand() {
        return brandService.retrieveBrand();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBrand(@PathVariable Long id) {
        Optional<Brand> brand = brandService.retrieveBrand(id);
        if(!brand.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brand);
    }

    @GetMapping("/search")
    public List<Brand> getBrand(@RequestParam(value = "Name") String Name ) {

        return brandService.retrieveBrand(Name);
    }

    @PostMapping()
    public ResponseEntity<?> postProduct(@Valid @RequestBody Brand body) {
        Brand brand = brandService.createBrand(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putBrand(@PathVariable Long id, @Valid @RequestBody Brand body) {
        Optional<Brand> brand = brandService.updateBrand(id, body);
        if(!brand.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        if(!brandService.deleteBrand(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}