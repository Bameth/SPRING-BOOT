package org.example.spring.web.dto.request;

import java.util.stream.Collectors;

import org.example.spring.data.entities.Client;
import org.example.spring.data.entities.Commande;
import org.example.spring.utils.validators.TelephoneUnique;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ClientCommandeRequestCreate {
    private Long id;
    @NotBlank(message = "Le nom complet est obligatoire")
    private String nomComplet;
    @NotBlank(message = "Le téléphone est obligatoire")
    @Pattern(regexp = "^[0-9]{9}$", message = "Le numéro de téléphone doit comporter 9 chiffres")
    @TelephoneUnique()
    private String telephone;
    @NotBlank(message = "Le pays est obligatoire")
    private String pays;
    @NotBlank(message = "La ville est obligatoire")
    private String ville;
    @NotBlank(message = "La rue est obligatoire")
    private String rue;
    private List<SimpleCommandeCreate> commandes = new ArrayList<>();

    public Client toEntity() {
        Client client = new Client();
        client.setNomComplet(nomComplet);
        client.setTelephone(telephone);
        client.setPays(pays);
        client.setVille(ville);
        client.setRue(rue);
        client.setCommandes(commandes.stream().map(c -> {
            Commande cmd = c.toEntity();
            cmd.setClient(client);
            return cmd;
        }).collect(Collectors.toList()));
        return client;
    }
}
