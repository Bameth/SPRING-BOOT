package org.example.spring.services;

import java.util.List;

import org.example.spring.data.entities.Commande;

public interface CommandeService {
    Commande create(Commande commandeRequest);

    Commande update(Long id, Commande commandeRequest);

    Commande getById(Long id);

    boolean delete(Long id);

    List<Commande> getAllCommandes();

    // List<Client> getClientsWithCommande(Long clientId);

}
