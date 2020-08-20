package com.example.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    public List<Category> retrieveCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Optional<Category> retrieveCategory(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> retrieveCategory(String Name) {
        return null;
    }

    public Category createCategory(Category category) {

        return categoryRepository.save(category);
    }

    public Optional<Category> updateCategory(Long id, Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(!categoryOptional.isPresent()) {
            return categoryOptional;
        }

        return Optional.of(categoryRepository.save(category));
    }

    public boolean deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}