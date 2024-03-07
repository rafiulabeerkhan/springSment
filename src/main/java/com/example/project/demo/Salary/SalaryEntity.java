package com.example.project.demo.Salary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryEntity {
    @Id
@GeneratedValue
    private Long employee_id;
    private String designation;
    private String paymentType;
    private Integer amount;
    private String overTime;
    private Integer bonus;
    private Integer totalAmount;

}
