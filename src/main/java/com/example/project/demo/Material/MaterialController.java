package com.example.project.demo.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class MaterialController {
    @Autowired
    public MaterialService service;

    @GetMapping("/getAll")
    public List<MaterialEntity> getAllMaterial(){
        return service.getAllMaterial();
    }
    @PostMapping
    public MaterialEntity addMaterial(@RequestBody MaterialEntity material ){
        return service.saveMaterial(material);
    }

    @GetMapping("/{id}")
    public MaterialEntity getMaterialById(@PathVariable("id")Long id){
        return service.getMaterialById(id);
    }

    @PutMapping("/{id}")
    public MaterialEntity updateMaterial(@RequestBody MaterialEntity material){
        return service.saveMaterial(material);
    }
    @DeleteMapping("/{id}")
    public void deleteMaterialById(@PathVariable("id")Long id){
        service.deleteMaterial(id);
    }
}
