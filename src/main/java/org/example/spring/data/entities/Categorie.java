package org.example.spring.data.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Categorie extends AbstracType {
    private String nom;
    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;
}
