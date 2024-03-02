package com.example.project.demo.invoice;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor

public class InvoiceEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String status;
    private String receiverSignature;
    private Date dateTime;
    private Long production_id;

}
