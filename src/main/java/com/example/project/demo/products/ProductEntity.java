package com.example.project.demo.products;

import com.example.project.demo.Material.Material;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@Getter
@Setter

@AllArgsConstructor
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue( generator = "SM09_",strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Products")
    private String productName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id")
    private Material rawMaterial;
    private Long workOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Material getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(Material rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public Long getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(Long workOrder) {
        this.workOrder = workOrder;
    }

    public ProductEntity() {
    }

    public ProductEntity(String productName, Material rawMaterial, Long workOrder) {
        this.productName = productName;
        this.rawMaterial = rawMaterial;
        this.workOrder = workOrder;
    }
}
