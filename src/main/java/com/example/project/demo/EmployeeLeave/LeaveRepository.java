package com.example.project.demo.EmployeeLeave;


import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, Long> {


}
