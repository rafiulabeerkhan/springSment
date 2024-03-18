package com.example.project.demo.invoice;

import com.example.project.demo.EmployeeLeave.LeaveEntity;
import com.example.project.demo.EmployeeLeave.LeaveService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class InvoiceController {
    @Autowired
    public InvoiceService service;
    @Autowired
    public InvoiceRepository repository;



    @GetMapping(value = "/pdf/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> downloadInvoice( @PathVariable("id") Long id) throws JRException, IOException {

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
                List.of(repository.findById(id).orElse(new InvoiceEntity()))
                , false);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("total", "7000");

        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/Invoice.jrxml"));

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
    public List<InvoiceEntity> getAllInvoice(){
        return service.getAllInvoice();
    }
    @PostMapping
    public InvoiceEntity addInvoice( @RequestBody InvoiceEntity invoice ){
        return service.saveInvoice(invoice);
    }

    @GetMapping("/{id}")
    public InvoiceEntity getInvoiceById(@PathVariable("id")Long id){
        return service.getInvoiceId(id);
    }

    @PutMapping("/{id}")
    public InvoiceEntity updateInvoice(@RequestBody InvoiceEntity invoice){
        return service.saveInvoice(invoice);
    }
    @DeleteMapping("/{id}")
    public void deleteInvoiceById(@PathVariable("id")Long id){
        service.deleteInvoice(id);
    }
}
