package com.example.project.demo.controller;

import com.example.project.demo.entity.Employees;
import com.example.project.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class EmployeesController {

    @Autowired
    public EmployeesService service;
@GetMapping("/getAll")
public List<Employees> getAllEmployees(){
return service.getAllEmployees();
}
@PostMapping
public Employees addEmployee( @RequestBody Employees employees){
return service.saveEmployees(employees);
}

@GetMapping("/{id}")
public Employees getEmployeeById(@PathVariable("id")Long id){
    return service.getEmployeesById(id);
}

@PutMapping("/")
public Employees updateEmployees(@RequestBody Employees employees){
    return service.saveEmployees(employees);
}
@DeleteMapping("/{id}")
public void deleteEmployeeById(@PathVariable("id")Long id){
     service.deleteEmployee(id);
}

}
