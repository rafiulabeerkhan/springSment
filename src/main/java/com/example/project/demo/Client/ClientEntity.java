package com.example.project.demo.Client;

import com.example.project.demo.Order.OrderEntity;
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
@NoArgsConstructor
@AllArgsConstructor

public class ClientEntity {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String clientName;
    private String designation;
    private String contactNo;
     private String officeAddress;
    private String orderInfo;
    private Long material_id;
    private Long product_id;
    private Integer quantity;

 @OneToMany(mappedBy = "clientEntity")
 @JsonIgnore
 private List<OrderEntity> orderEntities;
}
