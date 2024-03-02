package com.example.project.demo.Salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {
    @Autowired
    public SalaryRepository repo;

    public List<SalaryEntity> getAllSalary() {
        return repo.findAll();
    }

    public SalaryEntity getSalaryId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public SalaryEntity saveSalary(SalaryEntity salary) {
        return this.repo.save(salary);
    }

    public Boolean deleteSalary(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
