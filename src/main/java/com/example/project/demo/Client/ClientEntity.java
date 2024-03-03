package com.example.project.demo.Client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
