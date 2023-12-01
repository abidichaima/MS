package tn.esprit.ProjetSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idClub;
    String nomClub;
    String descriptionClub;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="club")
    private Set<Evenement> evenements;

    @ManyToOne
    Universite universite;
}
