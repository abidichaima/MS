package tn.esprit.ProjetSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ProjetSpring.entities.Matieres;

public interface MatieresRepository extends JpaRepository<Matieres,Integer> {
}
