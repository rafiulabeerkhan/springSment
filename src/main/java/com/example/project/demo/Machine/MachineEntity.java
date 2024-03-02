package com.example.project.demo.Machine;

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

public class MachineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long machine_id;
    private String country;
    private String status;
    private String pmProduction;
    private Long employee_id;

}
