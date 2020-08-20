package com.example.demo.producttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {
    private ProductTypeRepository producttypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository repository) {
        this.producttypeRepository = repository;
    }

    public List<ProductType> retrieveProductType() {
        return (List<ProductType>) producttypeRepository.findAll();
    }

    public Optional<ProductType> retrieveProductType(Long id) {
        return producttypeRepository.findById(id);
    }

    public List<ProductType> retrieveProductType(String Name) {
        return null;
    }

    public ProductType createProductType(ProductType producttype) {

        return producttypeRepository.save(producttype);
    }

    public Optional<ProductType> updateProductType(Long id, ProductType producttype) {
        Optional<ProductType> producttypeOptional = producttypeRepository.findById(id);
        if(!producttypeOptional.isPresent()) {
            return producttypeOptional;
        }

        return Optional.of(producttypeRepository.save(producttype));
    }

    public boolean deleteProductType(Long id) {
        try {
            producttypeRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}