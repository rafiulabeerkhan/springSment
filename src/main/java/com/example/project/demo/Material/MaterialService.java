package com.example.project.demo.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    public Repository repo;

    public List<Material> getAllMaterial() {
        return repo.findAll();
    }

    public Material getMaterialById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Material saveMaterial(Material material) {
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
