package tn.esprit.ProjetSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRestaurant;

    String nomRestaurant;
    Date dateOuverture;
    Date dateFermeture;
    @OneToOne
    private Universite universite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Set<Plat> plats;
}

