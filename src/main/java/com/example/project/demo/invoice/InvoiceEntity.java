package com.example.project.demo.invoice;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

@AllArgsConstructor

public class InvoiceEntity {
    private String status;
    private String receiverSignature;
    private Date dateTime;
    private Long production_id;

}
