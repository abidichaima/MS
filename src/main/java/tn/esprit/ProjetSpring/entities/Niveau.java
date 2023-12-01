package tn.esprit.ProjetSpring.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Niveau implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idNiveau;
    long niveau;
    String planEtude;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "niveau")
    private Set<Matieres> matieres;

    @ManyToOne
    Universite universite;

}
