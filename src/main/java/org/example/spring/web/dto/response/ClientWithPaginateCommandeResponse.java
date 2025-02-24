package org.example.spring.web.dto.response;

import java.util.List;

import org.example.spring.data.entities.Client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientWithPaginateCommandeResponse {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String pays;
    private String ville;
    private String rue;
    private List<CommandeSimpleResponse> commandes;

    public ClientWithPaginateCommandeResponse(Client client) {
        
        this.id = client.getId();
        this.nomComplet = client.getNomComplet();
        this.telephone = client.getTelephone();
        this.pays = client.getPays();
        this.ville = client.getVille();
        this.rue = client.getRue();
        this.commandes =client.getCommandes().stream().map(CommandeSimpleResponse::new).toList();

    }
}
