package com.example.project.demo.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    public InvoiceRepository repo;

    public List<InvoiceEntity> getAllInvoice() {
        return repo.findAll();
    }

    public InvoiceEntity getInvoiceId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public InvoiceEntity saveInvoice(InvoiceEntity invoice) {
        return this.repo.save(invoice);
    }

    public Boolean deleteInvoice(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
