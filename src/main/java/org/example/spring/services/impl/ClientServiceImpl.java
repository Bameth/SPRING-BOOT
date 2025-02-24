package org.example.spring.services.impl;

import java.util.Optional;

import org.example.spring.data.entities.Client;
import org.example.spring.data.repositories.ClientRepository;
import org.example.spring.data.repositories.CommandeRepository;
import org.example.spring.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Optional<Client> optionalData = clientRepository
                .findById(id);
        if (optionalData.isPresent()) {
            var data = optionalData.get();
            data.setNomComplet(clientRequest.getNomComplet());
            data.setPays(clientRequest.getPays());
            data.setRue(clientRequest.getRue());
            data.setTelephone(clientRequest.getTelephone());
            data.setVille(clientRequest.getVille());
            return clientRepository.save(data);
        }
        return null;
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Client> optionalData = clientRepository
                .findById(id);
        if (optionalData.isPresent()) {
            var data = optionalData.get();
            clientRepository.delete(data);
            return true;
        }
        return false;
    }

    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

}
