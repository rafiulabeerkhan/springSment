package com.example.project.demo.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    public ClientRepository repo;

    public List<ClientDTO> getAllClient() {
List<ClientEntity> clientEntityList = repo.findAll();
return clientEntityList.stream().map(this::fromEntityToDTO).collect(Collectors.toList());
    }
    public ClientDTO fromEntityToDTO(ClientEntity client){
        return new ClientDTO(client.getClientId(),client.getClientName(),
                client.getDesignation(),
                client.getContactNo(),
                client.getOfficeAddress(),
                client.getOrderInfo(),
                client.getQuantity());
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
