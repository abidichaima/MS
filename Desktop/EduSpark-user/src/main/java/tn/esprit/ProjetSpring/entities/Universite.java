package tn.esprit.ProjetSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;
    String nomUniversite;
    String adresseUniversite;
    String ville;
    String descriptonUniversite;
    int telUniversite;
    String emailUinversite;
    @OneToOne
     private Foyer foyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="universite")
    private Set<Club> clubs;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "universite")
     private Restaurant restaurant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universite")
    private Set<Niveau> niveaux;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universite")
    private Set<Actualite> actualites;

}
