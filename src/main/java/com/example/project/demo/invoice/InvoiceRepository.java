package com.example.project.demo.invoice;


import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {


}
