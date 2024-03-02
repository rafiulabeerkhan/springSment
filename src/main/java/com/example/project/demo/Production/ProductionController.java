package com.example.project.demo.Production;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductionController {
    @Autowired
    public ProductionService service;

    @GetMapping("/getAll")
    public List<ProductionEntity> getAllProduction(){
        return service.getAllProduction();
    }
    @PostMapping
    public ProductionEntity addProduction( @RequestBody ProductionEntity production ){
        return service.saveProduction(production);
    }

    @GetMapping("/{id}")
    public ProductionEntity getProductionById(@PathVariable("id")Long id){
        return service.getProductionId(id);
    }

    @PutMapping("/{id}")
    public ProductionEntity updateProduction(@RequestBody ProductionEntity production){
        return service.saveProduction(production);
    }
    @DeleteMapping("/{id}")
    public void deleteProductionById(@PathVariable("id")Long id){
        service.deleteProduction(id);
    }
}
