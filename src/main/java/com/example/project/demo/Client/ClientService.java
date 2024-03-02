package com.example.project.demo.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    public ClientRepository repo;

    public List<ClientEntity> getAllClient() {
        return repo.findAll();
    }

    public ClientEntity getClientId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public ClientEntity saveClient(ClientEntity client) {
        return this.repo.save(client);
    }

    public Boolean deleteClient(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
