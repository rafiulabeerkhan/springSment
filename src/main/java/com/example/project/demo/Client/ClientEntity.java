package com.example.project.demo.Client;

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

public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;
    private String name;
    private String designation;
    private Long contactNo;
    private String officeAddress;
    private String order;
    private Long material_id;
    private Long product_id;
    private Integer quantity;

}
