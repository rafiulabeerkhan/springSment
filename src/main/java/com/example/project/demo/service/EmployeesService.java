package com.example.project.demo.service;

import com.example.project.demo.entity.Employees;
import com.example.project.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {
    @Autowired
    public EmployeeRepository repo;

    public List<Employees> getAllEmployees() {
        return repo.findAll();
    }

    public Employees getEmployeesById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Employees saveEmployees(Employees employees) {
        return this.repo.save(employees);
    }

    public Boolean deleteEmployee(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
