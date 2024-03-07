package com.example.project.demo.Order;

import com.example.project.demo.OrderDetails.OrderDetailsEntity;
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
    private Long details_id;
    private Integer totalQuantity;
    private Integer price;
    private Integer totalPrice;
    private Integer due;
    private Long client_id;

    @OneToMany(mappedBy = "orderEntity")
    private List<OrderDetailsEntity> orderDetailsEntity;

}
