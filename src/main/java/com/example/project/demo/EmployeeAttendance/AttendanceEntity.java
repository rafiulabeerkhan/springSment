package com.example.project.demo.EmployeeAttendance;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
public class AttendanceEntity {
    @Id
    @GeneratedValue
    private Long employee_id;
    private String active;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
