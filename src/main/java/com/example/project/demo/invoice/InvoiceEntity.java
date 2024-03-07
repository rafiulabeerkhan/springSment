package com.example.project.demo.invoice;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String status;
    private String receiverName;
    private String receiverAddress;
    private String receiverItem;
    private Integer quantity;
    private Integer price;
    private Double discount;
    private Long grandTotal;
    private Date dateTime;
    private Long production_id;

}
