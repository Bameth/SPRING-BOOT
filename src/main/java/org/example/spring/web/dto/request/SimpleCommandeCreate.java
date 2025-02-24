package org.example.spring.web.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.example.spring.data.entities.Commande;
import org.example.spring.data.enums.StatutEnum;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class SimpleCommandeCreate {
    private StatutEnum status;
    private LocalDateTime dateCommande;
    @NotBlank(message = "Le montant de la commande est obligatoire")
    private Double montant;
    private String pays;
    private String ville;
    private String rue;

    public SimpleCommandeCreate() {
        dateCommande = LocalDateTime.now();
        status = StatutEnum.ENCOURS;
    }
    public Commande toEntity() {
        Commande commande = new Commande();
        commande.setDateCommande(LocalDate.now());
        commande.setMontant(montant);
        commande.setPays(pays);
        commande.setVille(ville);
        commande.setRue(rue);
        commande.setStatut(StatutEnum.ENCOURS);
        return commande;
    }
}
