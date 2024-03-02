package com.example.project.demo.Salary;


import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {


}
