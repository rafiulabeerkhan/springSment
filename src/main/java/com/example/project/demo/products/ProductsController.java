package com.example.project.demo.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductsController {
    @Autowired
    public ProductService service;

    @GetMapping("/getAll")
    public List<ProductEntity> getAllProduct(){
        return service.getAllProducts();
    }
    @PostMapping
    public ProductEntity addProduct( @RequestBody ProductEntity products ){
        return service.saveProduct(products);
    }

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable("id")Long id){
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductEntity updateProducts(@RequestBody ProductEntity products){
        return service.saveProduct(products);
    }
    @DeleteMapping("/{id}")
    public void deleteProductsById(@PathVariable("id")Long id){
        service.deleteProduct(id);
    }
}
