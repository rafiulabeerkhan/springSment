package com.example.project.demo.Production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService {
    @Autowired
    public ProductionRepository repo;

    public List<ProductionEntity> getAllProduction() {
        return repo.findAll();
    }

    public ProductionEntity getProductionId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public ProductionEntity saveProduction(ProductionEntity production) {
        return this.repo.save(production);
    }

    public Boolean deleteProduction(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
