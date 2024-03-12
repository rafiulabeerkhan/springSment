package com.example.project.demo.Production;

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

public class ProductionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long production_id;
    private Long id;
    private Long material_id;
    private Long employee_id;
    private Long machine_id;
    private String status;


}
