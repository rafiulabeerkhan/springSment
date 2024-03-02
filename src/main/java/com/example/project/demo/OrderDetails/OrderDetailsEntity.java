package com.example.project.demo.OrderDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

@AllArgsConstructor

public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long details_id;
    private Long product_id;
    private Integer quantity;
    private Integer price;
    private Integer totalPrice;
    private Date deliveryDate;

}
