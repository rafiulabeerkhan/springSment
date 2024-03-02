package com.example.project.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    public ProductRepository repo;

    public List<ProductEntity> getAllProducts() {
        return repo.findAll();
    }

    public ProductEntity getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return this.repo.save(product);
    }

    public Boolean deleteProduct(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
