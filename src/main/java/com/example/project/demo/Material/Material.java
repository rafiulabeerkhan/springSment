package com.example.project.demo.Material;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@jakarta.persistence.Entity
@Getter
@Setter

@AllArgsConstructor
@Table(name = "RawMaterials")
public class Material {
    @Id
    @GeneratedValue( generator = "mId09_",strategy = GenerationType.IDENTITY)
    private Long material_id;
    private String name;
    private String country;
    private Long price;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rawMaterial", cascade = CascadeType.ALL)
    private List<Entity> productsLists;

    public Long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Long material_id) {
        this.material_id = material_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<Entity> getProductsLists() {
        return productsLists;
    }

    public void setProductsLists(List<Entity> productsLists) {
        this.productsLists = productsLists;
    }

    public Material() {

    }

    public Material(String name, String country, Long price) {
        this.name = name;
        this.country = country;
        this.price = price;

    }
}
