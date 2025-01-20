package org.example.spring.services.impl;

import java.util.List;
import java.util.Optional;

import org.example.spring.data.entities.Commande;
import org.example.spring.data.repositories.CommandeRepository;
import org.example.spring.services.CommandeService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;

    @Override
    public Commande create(Commande commandeRequest) {
        return commandeRepository.save(commandeRequest);
    }

    @Override
    public Commande update(Long id, Commande commandeRequest) {
        Optional<Commande> commande = commandeRepository.findById(id);
        if (commande.isPresent()) {
            var data = commande.get();
            data.setDateCommande(commandeRequest.getDateCommande());
            data.setPays(commandeRequest.getPays());
            data.setRue(commandeRequest.getRue());
            data.setVille(commandeRequest.getVille());
            data.setMontant(commandeRequest.getMontant());
            data.setStatut(commandeRequest.getStatut());
            return commandeRepository.save(data);
        }
        return null;
    }

    @Override
    public Commande getById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Commande> commande = commandeRepository.findById(id);
        if (commande.isPresent()) {
            var data = commande.get();
            commandeRepository.delete(data);
            return true;
        }
        return false;
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

}
