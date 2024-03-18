package com.example.project.demo.Order;

import com.example.project.demo.Client.ClientEntity;
import com.example.project.demo.products.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderId;
    private Integer totalQuantity;
    private Integer price;
    private Integer totalPrice;
    private Integer due;
    //private Long client_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_entity_id" )
    private ProductEntity productEntity;

    //@OneToMany(mappedBy = "orderEntity")
    //@JsonIgnore
   // private List<OrderDetailsEntity> orderDetailsEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_entity_id" )
    private ClientEntity clientEntity;





}
