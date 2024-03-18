package com.example.project.demo.products;

import com.example.project.demo.Order.OrderEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private String productName;
    private Long material_id;
    private String material_name;
    private String workOrder;
    private Integer weight;

    @OneToMany(mappedBy = "productEntity")
    @JsonIgnore
    private List<OrderEntity> orderEntities;
}
