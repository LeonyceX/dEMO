package com.example.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategory() {
        return categoryService.retrieveCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id) {
        Optional<Category> category = categoryService.retrieveCategory(id);
        if(!category.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping("/search")
    public List<Category> getCategory(@RequestParam(value = "Name") String Name ) {
        return categoryService.retrieveCategory(Name);
    }

    @PostMapping()
    public ResponseEntity<?> postCategory(@Valid @RequestBody Category body) {
        Category category = categoryService.createCategory(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCategory(@PathVariable Long id, @Valid @RequestBody Category body) {
        Optional<Category> category = categoryService.updateCategory(id, body);
        if(!category.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        if(!categoryService.deleteCategory(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}