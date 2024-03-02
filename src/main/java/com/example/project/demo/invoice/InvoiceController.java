package com.example.project.demo.invoice;

import com.example.project.demo.EmployeeLeave.LeaveEntity;
import com.example.project.demo.EmployeeLeave.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class InvoiceController {
    @Autowired
    public InvoiceService service;

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
