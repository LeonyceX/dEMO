package com.example.demo.brand;

import com.example.demo.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository repository) {
        this.brandRepository = repository;
    }

    public List<Brand> retrieveBrand() {
        return (List<Brand>) brandRepository.findAll();
    }

    public Optional<Brand> retrieveBrand(Long id) {
        return brandRepository.findById(id);
    }

    public List<Brand> retrieveBrand(String Name) {
        return null;
    }

    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Optional<Brand> updateBrand(Long id, Brand brand) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if(!brandOptional.isPresent()) {
            return brandOptional;
        }

        return Optional.of(brandRepository.save(brand));
    }

    public boolean deleteBrand(Long id) {
        try {
            brandRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}