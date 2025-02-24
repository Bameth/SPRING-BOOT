package org.example.spring.data.repositories;

import org.example.spring.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Page<Commande> getCommandeByClientId(Long id, Pageable pageable);
}
