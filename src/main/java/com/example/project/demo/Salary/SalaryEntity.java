package com.example.project.demo.Salary;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@AllArgsConstructor

public class SalaryEntity {
    private Long employee_id;
    private String designation;
    private String paymentType;
    private Integer amount;
    private String overTime;
    private Integer bonus;
    private Integer totalAmount;

}
