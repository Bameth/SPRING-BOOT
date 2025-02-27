package org.example.spring.services.impl;


import org.example.spring.data.entities.Client;
import org.example.spring.data.repositories.ClientRepository;
import org.example.spring.data.repositories.CommandeRepository;
import org.example.spring.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;

    @Override
    public Client create(Client clientRequest) {
        return clientRepository.save(clientRequest);
    }

    @Override
    public Client update(Long id, Client clientRequest) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client avec l'ID " + id + " introuvable"));

        client.setNomComplet(clientRequest.getNomComplet());
        client.setPays(clientRequest.getPays());
        client.setRue(clientRequest.getRue());
        client.setTelephone(clientRequest.getTelephone());
        client.setVille(clientRequest.getVille());

        return clientRepository.save(client);
    }

    @Override
    public Client getById(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    @Override
    public boolean delete(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client avec l'ID " + id + " introuvable"));

        clientRepository.delete(client);
        return true;
    }

    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

}
