package com.example.project.demo.OrderDetails;

import com.example.project.demo.Order.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long product_id;
    private Integer quantity;
    private Integer price;
    private Integer totalPrice;
    private Date deliveryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_entity_id" )
    private OrderEntity orderEntity;


}
