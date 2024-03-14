package com.example.project.demo.controller;

import com.example.project.demo.entity.Employees;
import com.example.project.demo.repository.EmployeeRepository;
import com.example.project.demo.service.EmployeesService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class EmployeesController {

    @Autowired
    public EmployeesService service;

    @Autowired
    public EmployeeRepository repository;

    @GetMapping("/count")
    public Long countEmployees(){
        return service.countEmployees();
    }

    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> downloadInvoice() throws JRException, IOException {

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
                repository.findAll(), false);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("total", "7000");

        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/employees.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

        // JasperExportManager.exportReportToPdfFile(jasperPrint,
        // System.currentTimeMillis() + ".pdf");

        byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

        System.err.println(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }

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

@PutMapping("/{id}")
public Employees updateEmployees(@RequestBody Employees employees){
    return service.saveEmployees(employees);
}
@DeleteMapping("/{id}")
public void deleteEmployeeById(@PathVariable("id")Long id){
     service.deleteEmployee(id);
}

}
