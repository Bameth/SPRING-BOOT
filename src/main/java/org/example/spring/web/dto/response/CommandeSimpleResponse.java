package org.example.spring.web.dto.response;

import java.time.LocalDate;

import org.example.spring.data.entities.Commande;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CommandeSimpleResponse {
    private Long id;
    private LocalDate dateCommande;
    private String pays;
    private String ville;
    private String rue;
    private Double montant;
    public CommandeSimpleResponse(Commande commande) {
        this.id = commande.getId();
        this.dateCommande = commande.getDateCommande();
        this.pays = commande.getPays();
        this.ville = commande.getVille();
        this.rue = commande.getRue();
        this.montant = commande.getMontant();
    }
}
