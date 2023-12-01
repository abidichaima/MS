package tn.esprit.ProjetSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ProjetSpring.entities.Niveau;

public interface NiveauRepository extends JpaRepository<Niveau,Long> {
}
