package com.example.project.demo.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@AllArgsConstructor

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private Long details_id;
    private Integer totalQuantity;
    private Integer price;
    private Integer totalPrice;
    private Integer due;
    private Long client_id;

}
