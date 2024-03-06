package com.example.project.demo.entity;

import com.example.project.demo.Machine.MachineEntity;
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
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;
    private String firstName;
    private String lastName;
    private Long age;
    private String address;
    private Long nid;
    private String birthDate;
    private String shift;
    private Long workingHour;
    private String joiningDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_entity_id")
    private MachineEntity machineEntity;
}
