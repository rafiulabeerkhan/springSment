package com.example.project.demo.Machine;

import com.example.project.demo.entity.Employees;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder

public class MachineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long machine_id;
    private String country;
    private String status;
    private String pmProduction;
    private Long employee_id;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;

    @OneToMany(mappedBy = "machineEntity")
    private Set<Employees> employees;

}
