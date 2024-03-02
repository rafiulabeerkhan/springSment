package com.example.project.demo.Client;

import com.example.project.demo.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ClientController {
    @Autowired
    public ClientService service;

    @GetMapping("/getAll")
    public List<ClientEntity> getAllClient(){
        return service.getAllClient();
    }
    @PostMapping
    public ClientEntity addClient( @RequestBody ClientEntity client){
        return service.saveClient(client);
    }

    @GetMapping("/{id}")
    public ClientEntity getClientById(@PathVariable("id")Long id){
        return service.getClientId(id);
    }

    @PutMapping("/{id}")
    public ClientEntity updateClient(@RequestBody ClientEntity client){
        return service.saveClient(client);
    }
    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable("id")Long id){
        service.deleteClient(id);
    }
}
