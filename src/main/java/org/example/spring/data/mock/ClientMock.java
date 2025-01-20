package org.example.spring.data.mock;

import java.time.LocalDate;

import org.example.spring.data.entities.Client;
import org.example.spring.data.entities.Commande;
import org.example.spring.data.enums.StatutEnum;
import org.example.spring.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Order(1)
public class ClientMock implements CommandLineRunner {
    private final ClientService clientService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Client client = new Client();
            client.setNomComplet("nomComplet" + i);
            client.setTelephone("77100101" + i);
            client.setPays("pays" + i);
            client.setRue("rue" + i);
            client.setVille("ville" + i);
            for (int j = 0; j < 10; j++) {
                Commande commande = new Commande();
                commande.setDateCommande(LocalDate.now());
                commande.setMontant(10000.0 * j);
                commande.setPays("pays" + j);
                commande.setRue("rue" + j);
                commande.setVille("ville" + j);
                commande.setStatut(j % 2 == 0 ? StatutEnum.ENCOURS : StatutEnum.LIVREE);
                client.getCommandes().add(commande);
            }
            clientService.create(client);

        }
    }

}
