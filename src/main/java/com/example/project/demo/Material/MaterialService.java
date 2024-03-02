package com.example.project.demo.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    public MaterialRepository repo;

    public List<MaterialEntity> getAllMaterial() {
        return repo.findAll();
    }

    public MaterialEntity getMaterialById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public MaterialEntity saveMaterial(MaterialEntity material) {
        return this.repo.save(material);
    }

    public Boolean deleteMaterial(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
