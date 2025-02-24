package org.example.spring.web.dto.request;

import org.example.spring.data.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.example.spring.utils.validators.TelephoneUnique;

@Getter
@Setter
public class ClientSimpleCreate {
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

    public Client toEntity() {
        Client client = new Client();
        client.setNomComplet(this.nomComplet);
        client.setTelephone(this.telephone);
        client.setPays(this.pays);
        client.setVille(this.ville);
        client.setRue(this.rue);
        return client;
    }
}
