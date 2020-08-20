package com.example.demo.producttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producttypes")
public class ProductTypeController {

    @Autowired
    ProductTypeService producttypeService;

    @GetMapping()
    public List<ProductType> getProduct() {
        return producttypeService.retrieveProductType();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Optional<ProductType> product = producttypeService.retrieveProductType(id);
        if(!product.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search")
    public List<ProductType> getProductType(@RequestParam(value = "Name") String Name ) {
        return producttypeService.retrieveProductType(Name);
    }

    @PostMapping()
    public ResponseEntity<?> postProductType(@Valid @RequestBody ProductType body) {
        ProductType product = producttypeService.createProductType(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putProductType(@PathVariable Long id, @Valid @RequestBody ProductType body) {
        Optional<ProductType> producttype = producttypeService.updateProductType(id, body);
        if(!producttype.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductType(@PathVariable Long id) {
        if(!producttypeService.deleteProductType(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}