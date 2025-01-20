package org.example.spring.services;

import java.util.List;

import org.example.spring.data.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Client create(Client clientRequest);

    Client update(Long id, Client clientRequest);

    Client getById(Long id);

    boolean delete(Long id);

    Page<Client> getAllClients(Pageable pageable);

    // List<Client> getClientsWithCommande(Long clientId);

}
