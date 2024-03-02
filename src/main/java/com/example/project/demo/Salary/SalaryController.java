package com.example.project.demo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class SalaryController {
    @Autowired
    public SalaryService service;

    @GetMapping("/getAll")
    public List<SalaryEntity> getAllSalary(){
        return service.getAllSalary();
    }
    @PostMapping
    public SalaryEntity addSalary( @RequestBody SalaryEntity salary ){
        return service.saveSalary(salary);
    }

    @GetMapping("/{id}")
    public SalaryEntity getSalaryById(@PathVariable("id")Long id){
        return service.getSalaryId(id);
    }

    @PutMapping("/{id}")
    public SalaryEntity updateSalary(@RequestBody SalaryEntity salary){
        return service.saveSalary(salary);
    }
    @DeleteMapping("/{id}")
    public void deleteSalaryById(@PathVariable("id")Long id){
        service.deleteSalary(id);
    }
}
