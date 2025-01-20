package org.example.spring.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.example.spring.data.enums.StatutEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nomComplet;
    @Column(length = 25, unique = true, nullable = false)
    private String telephone;
    @Column(length = 100, nullable = true)
    private String pays;
    @Column(length = 100, nullable = true)
    private String ville;
    @Column(length = 100, nullable = true)
    private String rue;
    @OneToMany(mappedBy = "client",cascade = CascadeType.PERSIST)
    private List<Commande> commandes = new ArrayList<>();
}
