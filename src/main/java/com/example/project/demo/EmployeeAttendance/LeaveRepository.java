package com.example.project.demo.EmployeeAttendance;


import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface LeaveRepository extends JpaRepository<AttendanceEntity, Long> {


}
