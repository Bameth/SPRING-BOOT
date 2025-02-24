package org.example.spring.data.entities;

import java.time.LocalDate;

import org.example.spring.data.enums.StatutEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateCommande;
    @Column(length = 100, nullable = false)
    private String pays;
    @Column(length = 100, nullable = false)
    private String ville;
    @Column(length = 100, nullable = false)
    private String rue;
    private Double montant;
    @Enumerated(value = EnumType.STRING)
    private StatutEnum statut;
    @ManyToOne(optional = false)
    private Client client;

}