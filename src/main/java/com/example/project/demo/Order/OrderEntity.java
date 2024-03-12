package com.example.project.demo.Order;

import com.example.project.demo.Client.ClientDTO;
import com.example.project.demo.Client.ClientEntity;
import com.example.project.demo.OrderDetails.OrderDetailsEntity;
import com.example.project.demo.products.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalQuantity;
    private Integer price;
    private Integer totalPrice;
    private Integer due;
//    private Long client_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_entity_id" )
    @JsonIgnore
    private ProductEntity productEntity;

    @OneToMany(mappedBy = "orderEntity")
    @JsonIgnore
    private List<OrderDetailsEntity> orderDetailsEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_entity_id" )
    @JsonIgnore
    private ClientEntity clientEntity;





}
