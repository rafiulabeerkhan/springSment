package com.example.project.demo.Client;


import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {


}
