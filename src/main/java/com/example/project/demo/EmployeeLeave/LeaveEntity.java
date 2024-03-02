package com.example.project.demo.EmployeeLeave;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@AllArgsConstructor

public class LeaveEntity {
    private Long employee_id;
    private String leaveType;
    private Integer days;
    private String reason;
}
